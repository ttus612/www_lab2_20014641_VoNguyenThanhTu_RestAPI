package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "product_image")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long image_id;

    @Column(name = "path", length = 250, nullable = false)
    private String path;

    @Column(name = "alternative", length = 250, nullable = false)
    private String alternative;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
}

