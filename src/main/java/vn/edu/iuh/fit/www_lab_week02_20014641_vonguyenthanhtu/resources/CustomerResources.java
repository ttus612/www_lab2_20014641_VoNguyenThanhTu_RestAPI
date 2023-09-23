package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Customer;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.CustomerServices;

import java.util.List;
import java.util.logging.Logger;

@Path("/customers")
public class CustomerResources {
    private final CustomerServices customerServices;

    private Logger loggerFactory;
    private final Logger logger = loggerFactory.getLogger(this.getClass().getName());

    public CustomerResources() {
        customerServices = new CustomerServices();
    }

//    @GET
//    @Produces("text/plain")
//    public String hello() {
//        return "Hello, World!";
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers() {
//        List<Customer> customers = customerServices.getAll();
//        GenericEntity<List<Customer>> entity = new GenericEntity<List<Customer>>(customers) {};

        return Response.ok().build();
    }

}
