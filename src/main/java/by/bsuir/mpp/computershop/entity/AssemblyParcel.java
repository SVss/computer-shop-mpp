package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "assembly_parcel")
public class AssemblyParcel extends BaseEntity<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "order_id", insertable = false, updatable = false)
    private long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "order_id")
    private Order order;

    @Column(name = "cost", nullable = false)
    private long cost;

    @Column(name = "count", nullable = false)
    private long count;

    @Column(name = "done_count", nullable = false, columnDefinition = "int default 0")
    private long doneCount;

    @Column(name = "canceled", columnDefinition = "BIT", nullable = false)
    private boolean canceled = false;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parcel", cascade = CascadeType.ALL)
    private List<AssemblyComponent> components;

    @OneToMany(mappedBy = "parcel", targetEntity = AssemblerTask.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AssemblerTask> tasks;

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public long getCost() {
        return this.cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getDoneCount() {
        return this.doneCount;
    }

    public void setDoneCount(long doneCount) {
        this.doneCount = doneCount;
    }

    public List<AssemblyComponent> getComponents() {
        return components;
    }

    public void setComponents(List<AssemblyComponent> components) {
        this.components = components;
    }

    public List<AssemblerTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<AssemblerTask> tasks) {
        this.tasks = tasks;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}
