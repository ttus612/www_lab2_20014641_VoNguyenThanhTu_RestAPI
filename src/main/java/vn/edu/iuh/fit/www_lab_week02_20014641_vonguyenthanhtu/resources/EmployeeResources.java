package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Employee;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Order;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.CustomerService;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.EmployeeService;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService.IFEmployeeService;

import java.util.List;
import java.util.Optional;
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


    @PUT
    @Produces("application/json")
    @Path("delete/{id}")
    public Response deleteCustomer(@PathParam("id") long id){

        return Response.ok(  employeeServices.deleteEmpl(id)).build();
    }

    @PUT
    @Produces("application/json")
    @Path("edit/")
    public Employee updateEmployee(Employee employee){
        System.out.println(employee.getEmpId());
        if (employeeServices.update(employee)){
            return employee;
        }
        return null;
    }


    @GET
    @Produces("application/json")
    public Response getAllResponse() {
        List<Employee> entity = employeeServices.gettAllEmplActive();
        return Response.ok(entity).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getEmpl(@PathParam("id") long eid) {
        Optional<Employee> employee = employeeServices.get(eid, Employee.class);
        if (employee.isPresent()){
            return Response.ok(employee.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }


    @PUT
    @Produces("application/json")
    @Path("update_orderempl/{id}")
    public boolean updateOrderOfEmpl(Order order, @PathParam("id") long id){

        Employee existingEmployee = employeeServices.get(id, Employee.class).orElse(null);

        Order orderNew =  new Order(order.getOrderDate(), order.getEmployeee(), order.getCustomer(), order.getOrderDetails());

        if (existingEmployee != null){
            existingEmployee.addOrderOfEmpl(orderNew);
            employeeServices.update(existingEmployee);
            return true;
        }

        return false;
    }



}
