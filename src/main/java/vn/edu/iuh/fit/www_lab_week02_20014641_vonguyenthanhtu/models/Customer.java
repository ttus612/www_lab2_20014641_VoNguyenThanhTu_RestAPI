package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customer")
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

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;



}
