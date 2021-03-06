package by.bsuir.mpp.computershop.service;

import by.bsuir.mpp.computershop.entity.BaseEntity;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public interface SoftDeleteService<E extends BaseEntity<ID>, ID extends Serializable> extends CrudService<E, ID> {

    void restore(ID id) throws ServiceException;

    @Override
    Page<E> getAllPage(Pageable pageable) throws ServiceException;

    Page<E> getRemoved(Pageable pageable) throws ServiceException;
}
