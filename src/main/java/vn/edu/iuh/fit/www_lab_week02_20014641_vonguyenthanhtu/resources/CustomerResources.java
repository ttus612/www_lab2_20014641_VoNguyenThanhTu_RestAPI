package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.CustomerService;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService.IFCustomerService;

import java.util.List;
import java.util.logging.Logger;

@Path("/customers")
public class CustomerResources {
    private final IFCustomerService customerServices;

    private Logger loggerFactory;
    private final Logger logger = loggerFactory.getLogger(this.getClass().getName());

    public CustomerResources() {
        customerServices = new CustomerService();
    }

    @GET
    @Produces("application/json")
    public Response getAllResponse() {
        List<Customer> entity = customerServices.gettAllCusActive();
        return Response.ok(entity).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
//    public Response insertCustomer(Customer customer){
//        return Response.ok(customerServices.insert(customer)).build();
//    }
    public Customer insertCustomer(Customer customer){
        if (customerServices.insert(customer)){
            return customer;
        }
        return null;
    }

    @PUT
    @Produces("application/json")
    @Path("delete/{id}")
    public Response deleteCustomer(@PathParam("id") long id){

        return Response.ok(  customerServices.deleteCus(id)).build();
    }

    @PUT
    @Produces("application/json")
    @Path("edit/")
    public Customer updateCustomer(Customer customer){
        System.out.println(customer.getCustId());
        if (customerServices.update(customer)){
            return customer;
        }
        return null;
    }
}
