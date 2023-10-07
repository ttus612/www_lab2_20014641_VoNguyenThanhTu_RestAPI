package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.models.*;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.CustomerService;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.EmployeeService;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.OrderService;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.ProductService;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService.IFCustomerService;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService.IFEmployeeService;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService.IFOrderService;
import vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.services.interFaceService.IFProductService;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Path("/orders")
public class OrderResources {
    private final IFOrderService orderService;
    private final IFCustomerService customerService;
    private final IFEmployeeService employeeService;

    private final IFProductService productService;

    private Logger loggerFactory;
    private final Logger logger = loggerFactory.getLogger(this.getClass().getName());

    public OrderResources() {
        orderService = new OrderService();
        customerService = new CustomerService();
        employeeService = new EmployeeService();
        productService = new ProductService();
    }

//    @POST
//    @Produces("application/json")
//    @Consumes("application/json")
//    public Order createOrder(Order order){
//        if (orderService.insert(order)){
//            return order;
//        }
//        return null;
//    }

    @PUT
    @Produces("application/json")
    @Path("get_order/{id}/{id2}")
    public boolean updateProductImage(@PathParam("id") long id, @PathParam("id2") long id2, Order order) {
        Customer existingCustomer = customerService.get(id, Customer.class).orElse(null);

        Employee existingEmployee = employeeService.get(id2, Employee.class).orElse(null);

        Order orderCusNew =  new Order(order.getOrderDate(), order.getEmployeee(), order.getCustomer(), order.getOrderDetails());



            if (existingCustomer != null && existingEmployee != null){
                existingCustomer.addOrderOfCus(orderCusNew);
                existingEmployee.addOrderOfEmpl(orderCusNew);
                customerService.update(existingCustomer);
                employeeService.update(existingEmployee);

                return true;
            }

        return false;
    }

    @PUT
    @Produces("application/json")
    @Path("get_order_detail/{id}/{id2}")
    public boolean updateProductImage(@PathParam("id") long id,  @PathParam("id2") long id2,OrderDetail orderDetail) {
        Order existingOrder = orderService.get(id, Order.class).orElse(null);

        Product existingProduct = productService.get(id2, Product.class).orElse(null);

        OrderDetail orderDetailNew =  new OrderDetail( orderDetail.getOrder(), orderDetail.getProduct(), orderDetail.getQuantity(),orderDetail.getPrice(), orderDetail.getNote());


        if (existingOrder != null && existingProduct != null){
            existingOrder.addOrderDetail(orderDetailNew);
            existingProduct.addOrderDetail(orderDetailNew);
            orderService.update(existingOrder);
            productService.update(existingProduct);

            return true;
        }

        return false;
    }


    @GET
    @Produces("application/json")
    public Response getAllResponse() {
        List<Order> entity = orderService.getAll(Order.class);
        return Response.ok(entity).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getOrder(@PathParam("id") long eid) {
        Optional<Order> order = orderService.get(eid, Order.class);
        if (order.isPresent()){
            return Response.ok(order.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
