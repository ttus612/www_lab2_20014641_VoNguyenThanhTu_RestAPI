package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services;

import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.CustomerRepository;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService.IFCustomerService;

import java.util.List;

public class CustomerService extends GenerateService<Customer> implements IFCustomerService {
    private final CustomerRepository customerRepository;


    public CustomerService() {
        customerRepository = new CustomerRepository();
    }

    @Override
    public List<Customer> gettAllCusActive() {
        return customerRepository.gettAllCusActive();
    }

    @Override
    public boolean deleteCus(long id) {
        return customerRepository.inActiveCus(id);
    }


}
