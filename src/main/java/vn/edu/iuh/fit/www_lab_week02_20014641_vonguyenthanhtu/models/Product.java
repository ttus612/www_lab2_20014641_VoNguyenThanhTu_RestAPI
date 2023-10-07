package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums.ProductStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "Product.findAllProduct", query = "SELECT c FROM Product c WHERE c.status = :status"),
        @NamedQuery(name = "Product.inActiveProduct", query = "UPDATE Product c SET c.status = 0 WHERE c.id = :id"),
        @NamedQuery(name = "Product.activeProduct", query = "UPDATE Product c SET c.status = 1 WHERE c.id = :id"),
})
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
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductPrice> productPrices;

    public Product() {
    }

    public Product(String name, String description, String unit, String manufacturer_name, ProductStatus status, List<ProductImage> productImages, List<OrderDetail> orderDetails, List<ProductPrice> productPrices) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer_name = manufacturer_name;
        this.status = status;
        this.productImages = productImages;
        this.orderDetails = orderDetails;
        this.productPrices = productPrices;
    }

    public Product(String name, String description, String unit, String manufacturer_name, ProductStatus status) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer_name = manufacturer_name;
        this.status = status;
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
                ", productImages=" + getProductImagesAsString() +
                ", orderDetails=" + getOrderDetailsAsString() +
                ", productPrices=" + getProductPricesAsString() +
                '}';
    }

    private String getProductPricesAsString() {
        if (productPrices == null) {
            return "null";
        }
        StringBuilder result = new StringBuilder("[");
        for (ProductPrice productPrice : productPrices) {
            result.append(productPrice.toString()).append(" ");
            result.append(", ");
        }
        if (!productPrices.isEmpty()) {
            result.setLength(result.length() - 2);  // Loại bỏ dấu phẩy và khoảng trắng cuối cùng
        }
        result.append("]");
        return result.toString();
    }

    private String getOrderDetailsAsString() {
        if (orderDetails == null) {
            return "null";
        }
        StringBuilder result = new StringBuilder("[");
        for (OrderDetail orderDetail : orderDetails) {
            result.append(orderDetail.toString()).append(" ");
            result.append(", ");
        }
        if (!orderDetails.isEmpty()) {
            result.setLength(result.length() - 2);  // Loại bỏ dấu phẩy và khoảng trắng cuối cùng
        }
        result.append("]");
        return result.toString();
    }

    private String getProductImagesAsString() {
        if (productImages == null) {
            return "null";
        }
        StringBuilder result = new StringBuilder("[");
        for (ProductImage image : productImages) {
            result.append(image.toString()).append(" ");
            result.append(", ");
        }
        if (!productImages.isEmpty()) {
            result.setLength(result.length() - 2);  // Loại bỏ dấu phẩy và khoảng trắng cuối cùng
        }
        result.append("]");
        return result.toString();
    }


    public void addProductImage(ProductImage productImage) {
        if (this.productImages == null) {
            this.productImages = new ArrayList<>();
        }
        this.productImages.add(productImage);
        productImage.setProduct(this);
    }
    public void addProductPrice(ProductPrice productPrice) {
        if (this.productPrices == null) {
            this.productPrices = new ArrayList<>();
        }
        this.productPrices.add(productPrice);
        productPrice.setProduct(this);
    }


    public void addOrderDetail(OrderDetail orderDetailNew) {
        if (this.orderDetails == null) {
            this.orderDetails = new ArrayList<>();
        }
        this.orderDetails.add(orderDetailNew);
        orderDetailNew.setProduct(this);
    }
}

