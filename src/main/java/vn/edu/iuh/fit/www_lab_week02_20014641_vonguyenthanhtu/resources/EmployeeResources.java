package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Employee;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.CustomerService;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.EmployeeService;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService.IFEmployeeService;

import java.util.List;
import java.util.logging.Logger;

@Path("/employees")
public class EmployeeResources {
    private final IFEmployeeService employeeServices;

    private Logger loggerFactory;
    private final Logger logger = loggerFactory.getLogger(this.getClass().getName());

    public EmployeeResources() {
        employeeServices = new EmployeeService();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Employee insertEmployee(Employee employee){
        if (employeeServices.insert(employee)){
            return employee;
        }
        return null;
    }


    @GET
    @Produces("application/json")
    public Response getAllResponse() {
        List<Employee> entity = employeeServices.getAll(Employee.class);
        return Response.ok(entity).build();
    }
}
