package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services;

import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.CustomerRepository;

import java.util.List;

public class CustomerServices {
    private CustomerRepository customerRepository;

    public CustomerServices() {
        customerRepository = new CustomerRepository();
    }

//    public List<Customer> getAll(){
//            return customerRepository.getAllCus();
//    }

}
