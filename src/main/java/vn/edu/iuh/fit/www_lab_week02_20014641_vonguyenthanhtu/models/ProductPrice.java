package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models;

import jakarta.persistence.*;
import org.joda.time.DateTime;

import java.io.Serializable;

@Entity
@Table(name = "product_price")
public class ProductPrice{
    @Id
    @Column(name = "price_date_time", length = 50, nullable = false)
    private DateTime price_date_time;


    @ManyToOne
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "note", length = 250, nullable = false)
    private String note;
}
