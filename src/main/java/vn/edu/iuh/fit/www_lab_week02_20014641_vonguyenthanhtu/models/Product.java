package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums.ProductStatus;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long productId;
    @Column(name = "name", length = 250, nullable = false)
    private String name;
    @Column(name = "description", length = 250, nullable = false)
    private String description;
    @Column(name = "unit", length = 250, nullable = false)
    private String unit;
    @Column(name = "manufacturer_name", length = 250, nullable = false)
    private String manufacturer_name;
    @Column(name = "status", nullable = false)
    private ProductStatus status;

    //RELATIONSHIP
//    @OneToMany(mappedBy = "product")
//    @PrimaryKeyJoinColumn(name = "product_id")
//    private List<ProductImage> productImages;
//    @OneToMany(mappedBy = "product")
//    @PrimaryKeyJoinColumn(name = "product_id")
//    private List<ProductPrice> productPrices;
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;
}

