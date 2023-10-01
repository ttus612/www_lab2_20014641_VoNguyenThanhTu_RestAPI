package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models;

import jakarta.persistence.*;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import java.io.Serializable;

@Entity
@Table(name = "product_price")
public class ProductPrice{

    @Id
    @Column(name = "price_date_time", length = 50, nullable = false)
    private LocalDateTime price_date_time;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName ="product_id" )
    private Product product;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "note", length = 250, nullable = false)
    private String note;

    public ProductPrice() {
    }

    public ProductPrice(LocalDateTime price_date_time, Product product, double price, String note) {
        this.price_date_time = price_date_time;
        this.product = product;
        this.price = price;
        this.note = note;
    }

    public LocalDateTime getPrice_date_time() {
        return price_date_time;
    }

    public void setPrice_date_time(LocalDateTime price_date_time) {
        this.price_date_time = price_date_time;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "price_date_time=" + price_date_time +
                ", product=" + product +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}

