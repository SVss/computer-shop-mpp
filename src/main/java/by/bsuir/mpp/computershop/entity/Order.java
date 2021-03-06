package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "`order`")
public class Order extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "cost", nullable = false,
            insertable = false, updatable = false)
    private Long cost;

    @Column(name = "order_date", nullable = false)
    private Timestamp orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false,
            columnDefinition = Status.TYPE_DEFINITION,
            insertable = false, updatable = false)
    private Status status;

    @Column(name = "canceled", nullable = false)
    private Boolean canceled = false;

    @Column(name = "export_address", nullable = false)
    private String exportAddress;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Assembly> assemblies;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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

    public Boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }

    public List<Assembly> getAssemblies() {
        return assemblies;
    }

    public void setAssemblies(List<Assembly> assemblies) {
        this.assemblies = assemblies;
    }

    public String getExportAddress() {
        return exportAddress;
    }

    public void setExportAddress(String exportAddress) {
        this.exportAddress = exportAddress;
    }

    public enum Status {
        IN_PROGRESS {
            public String toString() {
                return "В процессе составления";
            }
        },
        READY {
            public String toString() {
                return "Принят";
            }
        };

        public static final String TYPE_DEFINITION = "ENUM ('IN_PROGRESS', 'READY')";

        public static final List<Status> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

        public static final int SIZE = VALUES.size();

        public abstract String toString();
    }

}
