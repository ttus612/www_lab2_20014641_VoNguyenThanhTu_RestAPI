package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService;

import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;

import java.util.List;

public interface IFCustomerService extends IFGenerateService<Customer> {
    public List<Customer> gettAllCusActive();

    public boolean deleteCus(long id);

}
