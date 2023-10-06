package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums.CustomerStatus;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums.EmployeeStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@NamedQueries({
        @NamedQuery(name = "Customer.findAllCus", query = "SELECT c FROM Customer c WHERE c.status = :status"),
        @NamedQuery(name = "Customer.inActiveCus", query = "UPDATE Customer c SET c.status = 0 WHERE c.id = :id"),
        @NamedQuery(name = "Customer.activeCus", query = "UPDATE Customer c SET c.status = 1 WHERE c.id = :id"),
})
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private long custId;

    @Column(name = "cust_name", length = 250, nullable = false)
    private String custName;

    @Column(name = "email", length = 250, nullable = false)
    private String email;

    @Column(name = "phone", length = 250, nullable = false)
    private String phone;

    @Column(name = "address", length = 250, nullable = false)
    private String address;

    @Column(name = "status", nullable = false)
    private CustomerStatus status;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> orders;

    public Customer() {
    }

    public Customer(long custId, String custName, String email, String phone, String address, CustomerStatus status) {
        this.custId = custId;
        this.custName = custName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public Customer(String custName, String email, String phone, String address, CustomerStatus status) {
        this.custName = custName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public Customer(long custId, String custName, String email, String phone, String address, CustomerStatus status, List<Order> orders) {
        this.custId = custId;
        this.custName = custName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.orders = orders;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", orders=" + orders +
                '}';
    }

    public void addOrderOfCus(Order orderNew) {
        if (this.orders == null) {
            this.orders = new ArrayList<>();
        }
        this.orders.add(orderNew);
        orderNew.setCustomer(this);
    }
}
