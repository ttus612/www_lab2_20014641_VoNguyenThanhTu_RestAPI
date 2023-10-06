package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services;

import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Product;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.ProductRepository;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.generality.GeneralityCRUD;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService.IFProductService;

import java.util.List;

public class ProductService extends GeneralityCRUD<Product> implements IFProductService {
    private final ProductRepository productRepository;

    public ProductService(){
        productRepository = new ProductRepository();
    };
    @Override
    public List<Product> gettAllProductActive() {
        return productRepository.gettAllProductActive();
    }

    @Override
    public boolean deleteProduct(long id) {
        return productRepository.inActiveProduct(id);
    }
}
