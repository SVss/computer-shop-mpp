package by.bsuir.mpp.computershop.service.impl;

import by.bsuir.mpp.computershop.entity.Order;
import by.bsuir.mpp.computershop.repository.OrderRepository;
import by.bsuir.mpp.computershop.service.OrderService;
import by.bsuir.mpp.computershop.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static by.bsuir.mpp.computershop.service.exception.wrapper.RepositoryCallWrapper.wrapRepositoryCall;

@Service
public class OrderServiceImpl extends AbstractCrudService<Order, Long> implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        super(orderRepository);
        this.orderRepository = orderRepository;
    }

    @Override
    public void accept(Long id) throws ServiceException {
        wrapRepositoryCall(() -> orderRepository.accept(id));
    }

    @Override
    public void startEdit(Long id) throws ServiceException {
        wrapRepositoryCall(() -> orderRepository.startEdit(id));
    }

    @Override
    public void finish(Long id) throws ServiceException {
        wrapRepositoryCall(() -> orderRepository.finish(id));
    }

    @Override
    public void unfinish(Long id) throws ServiceException {
        wrapRepositoryCall(() -> orderRepository.unfinish(id));
    }

    @Override
    public void cancel(Long id) throws ServiceException {
        wrapRepositoryCall(() -> orderRepository.cancel(id));
    }

    @Override
    public void renew(Long id) throws ServiceException {
        wrapRepositoryCall(() -> orderRepository.renew(id));
    }

    @Override
    protected void updateOnUpdate(Order entity) throws ServiceException {
        Order template = wrapRepositoryCall(() -> orderRepository.findOne(entity.getId()));
        entity.setCanceled(template.isCanceled());
        entity.setStatus(template.getStatus());
        entity.setCost(entity.getCost());
    }
}
