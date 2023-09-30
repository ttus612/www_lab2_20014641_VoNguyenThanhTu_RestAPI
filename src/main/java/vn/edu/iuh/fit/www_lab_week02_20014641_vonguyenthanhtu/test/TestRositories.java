package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.test;

import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums.CustomerStatus;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class TestRositories {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();

//        Customer c1 = new Customer("Nguyen Van A", "nguyenvana@gmail.com", "1230232561", "120/7 Nguyễn Văn Bảo, Gò Vấp", CustomerStatus.ACTIVE);
//        customerRepository.insert(c1);
//
//        Customer c2 = new Customer("Nguyen Van B", "nguyenvanb@gmail.com", "1230123256", "120/7 Nguyễn Văn Bảo, Gò Vấp", CustomerStatus.ACTIVE);
//        customerRepository.insert(c2);
//
//        Customer c3 = new Customer("Nguyen Van C", "nguyenvanc@gmail.com", "1230123256", "120/7 Nguyễn Văn Bảo, Gò Vấp", CustomerStatus.IN_ACTIVE);
//        customerRepository.insert(c3);
//
//        Customer c4 = new Customer("Nguyen Van D", "nguyenvand@gmail.com", "1230123256", "120/7 Nguyễn Văn Bảo, Gò Vấp", CustomerStatus.ACTIVE);
//        customerRepository.insert(c4);



//        List<Customer> customers = customerRepository.gettAllCusActive();
//        for (Customer c:
//                customers) {
//            System.out.println(c);
//        }

//        System.out.println("Customers truoc khi update: "+customerRepository.get(1, Customer.class));
//        boolean isDeleteCus = customerRepository.inActiveCus(1);
//        if (isDeleteCus){
//            System.out.println("SUCCES");
//        }else {
//            System.out.println("FAILSE");
//        }

//        Customer customer = new Customer(1, "Nguyễn Văn Aaaaawfwefweaaa", "nguyenvana@gmail.com", "123", "120/7 Nguyễn Văn Bảo, Gò Vấp", CustomerStatus.ACTIVE);
//        boolean isUpdateCus = customerRepository.update(customer);
//        if (isUpdateCus){
//            System.out.println("SUCCES");
//        }else {
//            System.out.println("FAILSE");
//        }

//        System.out.println("Customers sau khi update: "+customerRepository.get(1, Customer.class));
    }
}
