package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.db.ConnectDB;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.generality.GeneralityCRUD;

import java.util.List;

public class CustomerRepository extends GeneralityCRUD<Customer> {

}
