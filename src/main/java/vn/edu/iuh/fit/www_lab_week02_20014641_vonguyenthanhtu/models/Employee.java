package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models;

import jakarta.persistence.*;
import org.joda.time.DateTime;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums.EmployeeStatus;

import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long empId;

    @Column(name = "full_name", length = 250, nullable = false)
    private String fullName;

    @Column(name = "dob", nullable = false)
    private DateTime dob;

    @Column(name ="email", length = 250, unique = true)
    private String email;

    @Column(name = "phone", length = 250, nullable = false)
    private String phone;

    @Column(name = "address", length = 250, nullable = false)
    private String address;

    @Column(name = "status", nullable = false)
    private EmployeeStatus status;

    //RELATIONSHIP
    @OneToMany(mappedBy = "employeee")
    private List<Order> orders;


    public Employee() {
    }

    public Employee(long empId, String fullName, DateTime dob, String email, String phone, String address, EmployeeStatus status, List<Order> orders) {
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

    public DateTime getDob() {
        return dob;
    }

    public void setDob(DateTime dob) {
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
        return "Employeee{" +
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
}
