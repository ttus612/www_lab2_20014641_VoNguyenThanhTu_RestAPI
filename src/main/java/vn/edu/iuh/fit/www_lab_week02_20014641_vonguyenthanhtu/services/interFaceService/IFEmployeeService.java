package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService;

import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Employee;

import java.util.List;

public interface IFEmployeeService extends IFGenerateService<Employee> {
    public List<Employee> gettAllEmplActive();

    public boolean deleteEmpl(long id);
}
