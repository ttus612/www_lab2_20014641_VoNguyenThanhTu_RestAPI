package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services;

import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Employee;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.CustomerRepository;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.EmployeeRepository;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.repositories.generality.GeneralityCRUD;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService.IFEmployeeService;

import java.util.List;

public class EmployeeService extends GenerateService<Employee> implements IFEmployeeService {
    private final EmployeeRepository employeeRepository ;
    public EmployeeService() {
        employeeRepository = new EmployeeRepository();
    }

    @Override
    public List<Employee> gettAllEmplActive() {
        return employeeRepository.gettAllEmplActive();
    }

    @Override
    public boolean deleteEmpl(long id) {
        return employeeRepository.inActiveEml(id);
    }
}
