package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums.EmployeeStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(name = "Employee.findAllEmpl", query = "SELECT c FROM Employee c WHERE c.status = :status"),
        @NamedQuery(name = "Employee.inActiveEmpl", query = "UPDATE Employee c SET c.status = 0 WHERE c.id = :id"),
        @NamedQuery(name = "Employee.activeEmpl", query = "UPDATE Employee c SET c.status = 1 WHERE c.id = :id"),
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long empId;

    @Column(name = "full_name", length = 250, nullable = false)
    private String fullName;

    @Column(name = "dob", nullable = false)
    @JsonProperty("dob")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dob;

    @Column(name ="email", length = 250, unique = true)
    private String email;

    @Column(name = "phone", length = 250, nullable = false)
    private String phone;

    @Column(name = "address", length = 250, nullable = false)
    private String address;

    @Column(name = "status", nullable = false)
    private EmployeeStatus status;

    //RELATIONSHIP
    @OneToMany(mappedBy = "employeee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> orders;

    public Employee() {
    }

    public Employee(String fullName, LocalDateTime dob, String email, String phone, String address, EmployeeStatus status) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    public Employee(long empId, String fullName, LocalDateTime dob, String email, String phone, String address, EmployeeStatus status, List<Order> orders) {
        this.empId = empId;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.orders = orders;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
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

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
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
        return "Employee{" +
                "empId=" + empId +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", orders=" + orders +
                '}';
    }

    public void addOrderOfEmpl(Order orderNew) {
        if (this.orders == null) {
            this.orders = new ArrayList<>();
        }
        this.orders.add(orderNew);
        orderNew.setEmployeee(this);
    }
}
