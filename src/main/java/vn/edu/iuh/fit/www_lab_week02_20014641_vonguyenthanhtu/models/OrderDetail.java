package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_detail")
public class OrderDetail{

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "note")
    private String note;
}
