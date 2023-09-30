package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.db.ConnectDB;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums.CustomerStatus;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Employee;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.generality.GeneralityCRUD;

import java.util.List;
import java.util.Optional;

public class CustomerRepository extends GeneralityCRUD<Customer> {
    public List<Customer> gettAllCusActive(){
        return em.createNamedQuery("Customer.findAllCus", Customer.class).setParameter("status", CustomerStatus.ACTIVE).getResultList();
    }

    //DELETE NHAN VIEN (CAP NHAT TRANG THAI LA IN_ACTIVE)
    public boolean inActiveCus(long id){
        try {
            transaction.begin();
            em.createNamedQuery("Customer.inActiveCus").setParameter("id", id).executeUpdate();
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }

    }

    //CAP NHAT LAINHAN VIEN (CAP NHAT TRANG THAI LA ACTIVE)
    public boolean activeCus(long id){
        try {
            transaction.begin();
            em.createNamedQuery("Customer.activeCus").setParameter("id", id).executeUpdate();
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }

    }
}
