package CSCI318.salesms.interfaces.rest;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import CSCI318.salesms.application.internal.applicationServices.SalesService;
import CSCI318.salesms.application.internal.domainServices.OrderService;
import CSCI318.salesms.application.internal.queryServices.SalesQueryService;
import CSCI318.salesms.domain.model.aggregates.Order;
import CSCI318.salesms.interfaces.rest.dto.OrderDTO;
import CSCI318.salesms.interfaces.rest.transform.OrderDTOAssembler;

import java.util.List;
import java.util.stream.Collectors;

//This class deals with allowing api endpoints to be accessed
@RestController
@RequestMapping("/orders")
public class OrderController {
    
    private final OrderService orderService;
    private final SalesService salesService;
    private final SalesQueryService salesQueryService;

    //Creates a new OrderController object and by doing so creates a new OrderService object
    @Autowired
    public OrderController(OrderService orderService, SalesQueryService salesQueryService, SalesService salesService) {
        this.orderService = orderService;
        this.salesQueryService = salesQueryService;
        this.salesService = salesService;
    }
    
    //Creates a new Order object using an order defined in the request and sends it to the service layer to be saved
    @PostMapping
    String createOrder(@RequestBody Order newOrder) {
        Order order = orderService.addOrder(newOrder);
        if (order != null) {
            return "New order Created";
        }
        return "Either a product could not be found, did not have enough quantity to make the order, or a customer could not be found";
    }

    //Returns a list of all orders stored in the database. Uses DTOs to ensure users can't see all data stored
    @GetMapping
    List<OrderDTO> all() {
        return salesQueryService.getAllOrders()
            .stream()
            .map(order -> {
                return OrderDTOAssembler.toDTOfromClass(order);
            }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    OrderDTO getOrderById(@PathVariable Long id) {
        Order order = salesQueryService.getOrderDetails(id);
        
        return OrderDTOAssembler.toDTOfromClass(order);
    }

    @PutMapping("/{id}")
    String updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Order newOrder = salesService.updateOrderDetails(id, order);
        if (newOrder != null) {
            return "Order details updated";
        }
        return "Order could not be found";
    }

    @DeleteMapping("/{id}") 
    String removeCustomer(@PathVariable Long id) {
        salesService.removeOrder(id);
        return "Order removed";
    }

    @PutMapping("/{id}/shipped")
    String shipOrder(@PathVariable Long id) {
        Order newOrder = orderService.shipOrder(id);
        if (newOrder != null){
            return "Order has been shipped";
        }
        return "Order could not be found";
    }

    @PutMapping("/{id}/received")
    String receivedOrder(@PathVariable Long id) {
        Order newOrder = orderService.receivedOrder(id);
        if (newOrder != null){
            return "Order has been recieved by customer";
        }
        return "Order could not be found";
    }
}
