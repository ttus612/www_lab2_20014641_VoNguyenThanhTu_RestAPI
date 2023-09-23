package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models;

import jakarta.persistence.*;
import org.joda.time.DateTime;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "order_date", nullable = false)
    private DateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employee employeee;

    @ManyToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(long orderId, DateTime orderDate, Employee employeee, Customer customer, List<OrderDetail> orderDetails) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.employeee = employeee;
        this.customer = customer;
        this.orderDetails = orderDetails;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public DateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(DateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Employee getEmployeee() {
        return employeee;
    }

    public void setEmployeee(Employee employeee) {
        this.employeee = employeee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", employeee=" + employeee +
                ", customer=" + customer +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
