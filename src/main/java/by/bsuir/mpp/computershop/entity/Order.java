package by.bsuir.mpp.computershop.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.CANNOT_BE_NULL_MESSAGE;

@Entity
@Table(name = "`order`")
@DynamicInsert
public class Order extends BaseEntity<Long> {
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "cost", nullable = false)
    private Long cost;

    @Column(name = "order_date", nullable = false)
    private Timestamp orderDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false,
            columnDefinition = Status.TYPE_DEFINITION)
    private Status status;

    @Column(name = "canceled", nullable = false)
    private Boolean canceled = false;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "order")
    private Export export;

    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
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

    public void setAssemblies(List<Assembly> assemblyParcels) {
        this.assemblies = assemblyParcels;
    }

    public Export getExport() {
        return export;
    }

    public void setExport(Export export) {
        this.export = export;
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
        },
        FINISHED {
            public String toString() {
                return "Завершен";
            }
        };

        public static final String TYPE_DEFINITION = "ENUM ('IN_PROGRESS', 'READY', 'FINISHED')";

        public abstract String toString();
    }
}
