package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.UserAuthController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.controller.exception.InvalidDataException;
import by.bsuir.mpp.computershop.dto.brief.UserBriefDto;
import by.bsuir.mpp.computershop.dto.full.UserAuthFullDto;
import by.bsuir.mpp.computershop.dto.helper.UpdateUserPassDto;
import by.bsuir.mpp.computershop.entity.UserAuth;
import by.bsuir.mpp.computershop.service.UserAuthService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static by.bsuir.mpp.computershop.controller.exception.wrapper.ServiceCallWrapper.wrapServiceCall;

@RestController
public class UserAuthControllerImpl
        extends AbstractSoftDeleteController<UserBriefDto, UserAuthFullDto, UserAuth, Long>
        implements UserAuthController {

    private static final Logger logger = Logger.getLogger(UserAuthControllerImpl.class);
    private final PasswordEncoder passwordEncoder;
    private final UserAuthService userService;

    @Autowired
    public UserAuthControllerImpl(UserAuthService userAuthService, MapperFacade mapper, PasswordEncoder passwordEncoder) {
        super(userAuthService, mapper, UserBriefDto.class, UserAuthFullDto.class, UserAuth.class, logger);
        this.userService = userAuthService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void updatePassword(@Valid @RequestBody UpdateUserPassDto passDto) throws ControllerException {
        logger.info(String.format("UPDATE PASS of user with id = [%s]", passDto.getUserId().toString()));
        String password = passDto.getNewHash();
        if (password == null || password.isEmpty()) {
            throw new InvalidDataException();
        }
        String passHash = passwordEncoder.encode(password);
        passDto.setNewHash(passHash);
        wrapServiceCall(() -> userService.updatePasswordHash(passDto), logger);
    }

    @Override
    public void dropUser(@PathVariable Long id) throws ControllerException {
        logger.info(String.format("DROP USER with id = [%s]", id.toString()));
        wrapServiceCall(() -> userService.dropUser(id), logger);
    }

    @Override
    protected boolean checkBeforeInsert(UserAuthFullDto dto) {
        return (dto.getPass() != null) && (!dto.getPass().isEmpty());
    }
}
