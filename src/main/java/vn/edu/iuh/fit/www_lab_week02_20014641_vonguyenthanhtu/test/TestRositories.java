package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.test;

import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums.CustomerStatus;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums.ProductStatus;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.*;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.CustomerRepository;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.EmployeeRepository;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.ProductRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TestRositories {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
//
        Product product1 = new Product("SAN PHAM 3", "SAN PHAM TOT NHAT ", "UNIT", "GO VAP", ProductStatus.ACTIVE,
                null,null,null);

//        List<ProductImage> productImages = new ArrayList<ProductImage>();
//        ProductImage productImage1 = new ProductImage("public/anh5.jpg","PRODUCT: "+ product1.getName(), null);
//        ProductImage productImage2 = new ProductImage("public/anh6.jpg","PRODUCT: "+ product1.getName(), null);
//        productImages.add(productImage1);
//        productImages.add(productImage2);
//
//        for (ProductImage productImage : productImages) {
//            product1.addProductImage(productImage);
//        }

//        List<ProductPrice> productPrices = new ArrayList<ProductPrice>();
//        ProductPrice productPrice1 = new ProductPrice(LocalDateTime.now(), null, 5.0, "PRODUCT: "+ product1.getProductId());
//        productPrices.add(productPrice1);

//        for (ProductPrice productPrice : productPrices) {
//            product1.addProductPrice(productPrice);
//        }

        if (productRepository.insert(product1)){
            System.out.println("THANH CONG");
        }else {
            System.out.println("KHONG THANH CONG");
         }

    }
}
