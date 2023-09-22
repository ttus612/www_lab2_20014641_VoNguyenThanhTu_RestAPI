package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EmployeeRepository {
    private EntityManager em;
    public EmployeeRepository(){
        em = Persistence.createEntityManagerFactory("lab_week_2").createEntityManager();
    }
}
