package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.ProviderController;
import by.bsuir.mpp.computershop.controller.exception.ControllerException;
import by.bsuir.mpp.computershop.dto.ImportDto;
import by.bsuir.mpp.computershop.dto.ProviderDto;
import by.bsuir.mpp.computershop.entity.Provider;
import by.bsuir.mpp.computershop.service.ProviderService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static by.bsuir.mpp.computershop.controller.exception.wrapper.ServiceCallWrapper.wrapServiceCall;

@RestController
public class ProviderControllerImpl extends AbstractCrudController<Provider, Long>
        implements ProviderController {

    private static final Logger logger = Logger.getLogger(ProviderControllerImpl.class);
    private final ProviderService service;
    private MapperFacade mapper;

    @Autowired
    public ProviderControllerImpl(ProviderService providerService, MapperFacade mapper) {
        super(providerService, mapper, ProviderDto.class, logger);
        this.service = providerService;
        this.mapper = mapper;
    }

    @Override
    public Iterable<ImportDto> getImports(@PathVariable Long id) throws ControllerException {
        logger.info(String.format("GET LIST of imports by Provider with id = [%s]", id));
        return StreamSupport.stream(wrapServiceCall(() -> service.getImports(id), logger).spliterator(), false)
                .map(i -> mapper.map(i, ImportDto.class))
                .collect(Collectors.toList());
    }
}
