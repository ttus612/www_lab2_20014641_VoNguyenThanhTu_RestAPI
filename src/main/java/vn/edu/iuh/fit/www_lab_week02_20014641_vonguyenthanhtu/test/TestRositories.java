package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.test;

import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.CustomerRepository;

import java.util.List;

public class TestRositories {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();

//        Customer c1 = new Customer("120/7 Nguyễn Văn Bảo, Gò Vấp", "Nguyen Van C", "nguyenvanc@gmail.com", "123023256");
//        boolean isAddCus = customerRepository.insert(c1);
//        if (isAddCus  == true){
//            System.out.println("Thêm thành công");
//        }else{
//            System.out.println("Thêm không thành công");
//        }

//        List<Customer> customers = customerRepository.getAll(Customer.class);
//        for (Customer c:
//                customers) {
//            System.out.println(c);
//        }

//        boolean isDeleteCus = customerRepository.delete(4, Customer.class);
//        if (isDeleteCus){
//            System.out.println("SUCCES");
//        }else {
//            System.out.println("FAILSE");
//        }

//        Customer customer = new Customer(1, "Nguyễn Văn A", "nguyenvana@gmail.com", "123", "120/7 Nguyễn Văn Bảo, Gò Vấp");
//        boolean isUpdateCus = customerRepository.update(customer);
//        if (isUpdateCus){
//            System.out.println("SUCCES");
//        }else {
//            System.out.println("FAILSE");
//        }

        System.out.println(customerRepository.get(1, Customer.class));
    }
}
