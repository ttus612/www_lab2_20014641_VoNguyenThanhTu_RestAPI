package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService;

import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Employee;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Product;

import java.util.List;
import java.util.Optional;

public interface IFProductService extends IFGenerateService<Product> {
    public List<Product> gettAllProductActive();

    public boolean deleteProduct(long id);

}
