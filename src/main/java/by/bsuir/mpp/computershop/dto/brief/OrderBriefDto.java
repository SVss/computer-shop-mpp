package by.bsuir.mpp.computershop.dto.brief;

import by.bsuir.mpp.computershop.entity.Order.Status;

import java.sql.Timestamp;

public class OrderBriefDto extends BaseBriefDto<Long> {

    private CustomerBriefDto customer;

    private Long cost;

    private Timestamp orderDate;

    private Status status;

    private Boolean canceled;

    public CustomerBriefDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerBriefDto customer) {
        this.customer = customer;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp ordDate) {
        this.orderDate = ordDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }
}
