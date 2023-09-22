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
    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductPrice> productPrices;

    public Product() {
    }

    public Product(long productId, String name, String description, String unit, String manufacturer_name, ProductStatus status, List<ProductImage> productImages, List<OrderDetail> orderDetails, List<ProductPrice> productPrices) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer_name = manufacturer_name;
        this.status = status;
        this.productImages = productImages;
        this.orderDetails = orderDetails;
        this.productPrices = productPrices;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(List<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturer_name='" + manufacturer_name + '\'' +
                ", status=" + status +
                ", productImages=" + productImages +
                ", orderDetails=" + orderDetails +
                ", productPrices=" + productPrices +
                '}';
    }
}

