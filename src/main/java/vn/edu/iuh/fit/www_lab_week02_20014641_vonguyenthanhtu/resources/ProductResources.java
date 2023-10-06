package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.resources;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Employee;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.Product;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.EmployeeService;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.ProductService;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService.IFEmployeeService;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService.IFProductService;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Path("/products")
public class ProductResources {
    private final IFProductService productService ;

    private Logger loggerFactory;
    private final Logger logger = loggerFactory.getLogger(this.getClass().getName());

    public ProductResources() {
        productService = new ProductService();
    }


    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Product insertProduct(Product product){
        if (productService.insert(product)){
            return product;
        }
        return null;
    }


    @PUT
    @Produces("application/json")
    @Path("delete/{id}")
    public Response deleteProduct(@PathParam("id") long id){

        return Response.ok(  productService.deleteProduct(id)).build();
    }

    @PUT
    @Produces("application/json")
    @Path("edit/")
    public Product updateProduct(Product product){
        System.out.println(product.getProductId());
        if (productService.update(product)){
            return product;
        }
        return null;
    }


    @GET
    @Produces("application/json")
    public Response getAllResponse() {
        List<Product> entity = productService.gettAllProductActive();
        return Response.ok(entity).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getProduct(@PathParam("id") long eid) {
        Optional<Product> product = productService.get(eid, Product.class);
        if (product.isPresent()){
            return Response.ok(product.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
