package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services;

import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.generality.GeneralityCRUD;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService.IFGenerate;

import java.util.List;
import java.util.Optional;

public class Generate<T> implements IFGenerate<T> {
    protected final GeneralityCRUD<T> tGeneralityCRUD;

    public Generate() {
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
        return false;
    }

    @Override
    public boolean update(T obj) {
        return false;
    }

    @Override
    public boolean delete(Object id, Class<T> clazz) {
        return false;
    }
}
