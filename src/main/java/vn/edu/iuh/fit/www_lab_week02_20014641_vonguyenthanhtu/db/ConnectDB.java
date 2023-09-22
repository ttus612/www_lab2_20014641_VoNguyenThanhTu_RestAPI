package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.db;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectDB {
    private static ConnectDB instance;

    private EntityManagerFactory emf;

    private ConnectDB(){
        emf =Persistence.createEntityManagerFactory("lab_week2");
    }

    public static ConnectDB getInstance() {
        if (instance == null){
            instance = new ConnectDB();
        }
        return instance;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
}
