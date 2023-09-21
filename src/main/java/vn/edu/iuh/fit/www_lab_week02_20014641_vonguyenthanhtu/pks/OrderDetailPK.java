package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.pks;

import jakarta.persistence.*;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Order;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Product;

import java.io.Serializable;

@Embeddable
public class OrderDetailPK implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
}
