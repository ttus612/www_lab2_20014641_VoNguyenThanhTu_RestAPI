package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.generality;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.db.ConnectDB;

import java.util.List;
import java.util.Optional;

public class GeneralityCRUD<T> implements IFGenerality<T> {
    protected final EntityManager em;
    protected final EntityManagerFactory emf;
    protected final EntityTransaction transaction ;
    public GeneralityCRUD(){
        emf = ConnectDB.getInstance().getEmf();
        em = emf.createEntityManager();
        transaction = em.getTransaction();
    }
    @Override
    public Optional<T> get(Object id, Class<T> clazz) {
        T obj = em.find(clazz, id);
        return obj == null ? Optional.empty() : Optional.of(obj);
    }

    @Override
    public List<T> getAll(Class<T> clazz) {
        String query ="SELECT e FROM "+ clazz.getSimpleName()+" e";
        TypedQuery<T> tTypedQuery =em.createQuery(query, clazz);
        return tTypedQuery.getResultList();
    }

    @Override
    public boolean insert(T obj) {
        try {
            transaction.begin();
            em.persist(obj);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean update(T obj) {
        try {
            transaction.begin();
            em.merge(obj);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean delete( Object id, Class<T> clazz) {
        try {
            transaction.begin();
            T obj = em.find(clazz, id); // Retrieve the entity by ID
            if (obj != null) {
                em.remove(obj); // Delete the entity
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

}
