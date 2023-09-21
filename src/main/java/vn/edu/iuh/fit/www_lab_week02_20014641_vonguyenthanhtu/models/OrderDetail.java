package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.pks.OrderDetailPK;

import java.io.Serializable;

@Entity
@Table(name = "order_detail")
public class OrderDetail{

    @EmbeddedId
    private OrderDetailPK orderDetailPK;

    @Column(name = "quantity")
    private long quantity;
    @Column(name = "price")
    private double price;
    @Column(name = "note")
    private String note;
}
