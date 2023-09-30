package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services;

import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.generality.GeneralityCRUD;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService.IFGenerateService;

import java.util.List;
import java.util.Optional;

public class GenerateService<T> implements IFGenerateService<T> {
    protected final GeneralityCRUD<T> tGeneralityCRUD;

    public GenerateService() {
       tGeneralityCRUD = new GeneralityCRUD<>();
    }

    @Override
    public Optional<T> get(Object id, Class<T> clazz) {
        return Optional.empty();
    }

    @Override
    public List<T> getAll(Class<T> clazz) {
        return tGeneralityCRUD.getAll(clazz);
    }

    @Override
    public boolean insert(T obj) {
        return tGeneralityCRUD.insert(obj);
    }

    @Override
    public boolean update(T obj) {
        return tGeneralityCRUD.update(obj);
    }

    @Override
    public boolean delete(Object id, Class<T> clazz) {
        return false;
    }
}
