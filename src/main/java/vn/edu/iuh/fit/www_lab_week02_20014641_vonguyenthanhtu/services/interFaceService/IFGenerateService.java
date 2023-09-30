package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService;

import java.util.List;
import java.util.Optional;

public interface IFGenerateService<T>{
    Optional<T> get(Object id , Class<T> clazz);

    List<T> getAll(Class<T> clazz);

    boolean insert(T obj);

    boolean update(T obj);

    boolean delete(Object id, Class<T> clazz);
}
