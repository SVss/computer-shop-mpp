package by.bsuir.mpp.computershop.controller.impl;

import by.bsuir.mpp.computershop.controller.ComponentStoreController;
import by.bsuir.mpp.computershop.dto.brief.ComponentStoreBriefDto;
import by.bsuir.mpp.computershop.dto.full.ComponentStoreFullDto;
import by.bsuir.mpp.computershop.entity.ComponentStore;
import by.bsuir.mpp.computershop.service.ComponentStoreService;
import ma.glasnost.orika.MapperFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComponentStoreControllerImpl
        extends AbstractReadController<ComponentStoreBriefDto, ComponentStoreFullDto, ComponentStore, Long>
        implements ComponentStoreController {

    private static final Logger logger = Logger.getLogger(ComponentStoreControllerImpl.class);

    @Autowired
    public ComponentStoreControllerImpl(ComponentStoreService storeService, MapperFacade mapper) {
        super(storeService, mapper, ComponentStoreBriefDto.class, ComponentStoreFullDto.class, logger);
    }
}
