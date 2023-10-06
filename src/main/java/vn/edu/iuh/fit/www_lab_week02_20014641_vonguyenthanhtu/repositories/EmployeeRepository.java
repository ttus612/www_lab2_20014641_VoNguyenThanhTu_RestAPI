package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories;

import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums.CustomerStatus;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Employee;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.generality.GeneralityCRUD;

import java.util.List;

public class EmployeeRepository extends GeneralityCRUD<Employee> {

    public List<Employee> gettAllEmplActive(){
        return em.createNamedQuery("Employee.findAllEmpl", Employee.class).setParameter("status", EmployeeStatus.ACTIVE).getResultList();
    }

    //DELETE NHAN VIEN (CAP NHAT TRANG THAI LA IN_ACTIVE)
    public boolean inActiveEml(long id){
        try {
            transaction.begin();
            em.createNamedQuery("Employee.inActiveEmpl").setParameter("id", id).executeUpdate();
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }

    }

    //CAP NHAT LAINHAN VIEN (CAP NHAT TRANG THAI LA ACTIVE)
    public boolean activeEmpl(long id){
        try {
            transaction.begin();
            em.createNamedQuery("Employee.activeEmpl").setParameter("id", id).executeUpdate();
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }

    }
}
