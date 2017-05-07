package by.bsuir.mpp.computershop.controller;

import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.brief.UserBriefDto;
import by.bsuir.mpp.computershop.dto.full.UpdatePassDto;
import by.bsuir.mpp.computershop.dto.full.UserAuthFullDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("api/user")
public interface UserAuthController
        extends WithRestoreController<UserBriefDto, UserAuthFullDto, Long> {

    @RequestMapping(value = "update/password", method = RequestMethod.POST)
    void updatePassword(@RequestBody UpdatePassDto passDto) throws ControllerException;

    @RequestMapping(value = "drop/{id}", method = RequestMethod.DELETE)
    void dropUser(@PathVariable Long id) throws ControllerException;
}
