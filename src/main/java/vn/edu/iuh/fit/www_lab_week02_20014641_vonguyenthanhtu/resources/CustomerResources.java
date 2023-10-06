package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Order;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.CustomerService;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService.IFCustomerService;

import java.util.List;
import java.util.Optional;
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

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getCuss(@PathParam("id") long eid) {
        Optional<Customer> customer = customerServices.get(eid, Customer.class);
        if (customer.isPresent()){
            return Response.ok(customer.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
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

    @PUT
    @Produces("application/json")
    @Path("update_ordercus/{id}")
    public boolean updateOrderOfCus(Order order, @PathParam("id") long id){

        Customer existingCustomer = customerServices.get(id, Customer.class).orElse(null);

        Order orderNew =  new Order(order.getOrderDate(), order.getEmployeee(), order.getCustomer(), order.getOrderDetails());

        if (existingCustomer != null){
            existingCustomer.addOrderOfCus(orderNew);
            customerServices.update(existingCustomer);
            return true;
        }

        return false;
    }
}
