package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.db.ConnectDB;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;

import java.util.List;

public class CustomerRepository {
    private EntityManager em;
    private EntityManagerFactory emf;
    public CustomerRepository(){
        emf = ConnectDB.getInstance().getEmf();
        em = emf.createEntityManager();
    }

    public List<Customer> getAllCus(){
        String sql = "SELECT * FROM customer";
        List<Customer> customers = em.createNativeQuery(sql, Customer.class).getResultList();
        return customers;
    }
}
