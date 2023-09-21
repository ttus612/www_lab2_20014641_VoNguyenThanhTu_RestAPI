package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models;

import jakarta.persistence.*;
import org.joda.time.DateTime;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums.EmployeeStatus;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employeee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long empId;
    @Column(name = "full_name", length = 150, nullable = false)
    private String fullName;
    @Column(name = "dob", nullable = false)
    private DateTime dob;
    @Column(name ="email", length = 150, unique = true)
    private String email;
    @Column(name = "phone", length = 15, nullable = false)
    private String phone;
    @Column(name = "address", length = 250, nullable = false)
    private String address;
    @Column(name = "status", nullable = false)
    private EmployeeStatus status;

    //RELATIONSHIP
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Order> orders;

}
