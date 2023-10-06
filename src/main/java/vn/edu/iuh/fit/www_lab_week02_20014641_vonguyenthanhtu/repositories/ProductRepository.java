package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories;

import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums.EmployeeStatus;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums.ProductStatus;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.*;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.generality.GeneralityCRUD;

import java.util.List;

public class ProductRepository extends GeneralityCRUD<Product> {
    public List<Product> gettAllProductActive(){
        return em.createNamedQuery("Product.findAllProduct", Product.class).setParameter("status", ProductStatus.ACTIVE).getResultList();
    }


    //DELETE NHAN VIEN (CAP NHAT TRANG THAI LA IN_ACTIVE)
    public boolean inActiveProduct(long id){
        try {
            transaction.begin();
            em.createNamedQuery("Product.inActiveProduct").setParameter("id", id).executeUpdate();
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }

    }

    //CAP NHAT LAINHAN VIEN (CAP NHAT TRANG THAI LA ACTIVE)
    public boolean activeProduct(long id){
        try {
            transaction.begin();
            em.createNamedQuery("Product.activeProduct").setParameter("id", id).executeUpdate();
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }

}
