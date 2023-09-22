package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.test;

import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.CustomerRepository;

import java.util.List;

public class TestRositories {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        List<Customer> customers = customerRepository.getAllCus();
        for (Customer c:
             customers) {
            System.out.println(c);
        }
    }
}
