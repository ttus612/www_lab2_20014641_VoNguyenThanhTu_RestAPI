package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.db.ConnectDB;

public class TestConnectDB {
    public static void main(String[] args) {
        ConnectDB connectDB = ConnectDB.getInstance();

        // Lấy EntityManagerFactory từ ConnectDB
        EntityManagerFactory emf = connectDB.getEmf();

        // Tạo một EntityManager từ EntityManagerFactory
        EntityManager em = emf.createEntityManager();

        // Kiểm tra kết nối cơ sở dữ liệu bằng cách in ra thông tin EntityManager
        System.out.println("EntityManager created: " + em);

        // Đóng EntityManager khi bạn đã sử dụng xong
        em.close();

        // Đóng EntityManagerFactory khi bạn đã sử dụng xong
        emf.close();
    }
}
