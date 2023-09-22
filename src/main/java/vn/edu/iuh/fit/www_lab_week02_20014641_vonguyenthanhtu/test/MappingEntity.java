package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.MySessionFactory;

public class MappingEntity {
    public static void main(String[] args) {
        MySessionFactory.getInstance();
    }
}
