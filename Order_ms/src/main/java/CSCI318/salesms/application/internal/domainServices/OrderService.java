package CSCI318.salesms.application.internal.domainServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import CSCI318.shareddomain.events.SalesTransportEvent;
import CSCI318.shareddomain.events.SalesTransportEventData;
import CSCI318.salesms.domain.model.aggregates.Order;
import CSCI318.salesms.domain.model.aggregates.Product;
import CSCI318.salesms.infrastructure.repositories.OrderRepository;
import CSCI318.salesms.application.internal.outboundServices.SalesEventPublisherService;
import CSCI318.salesms.application.internal.outboundServices.acl.ExternalCustomerAccountService;
import CSCI318.salesms.application.internal.outboundServices.acl.ExternalProcurementService;
import CSCI318.salesms.application.internal.queryServices.SalesQueryService;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final SalesEventPublisherService salesEventPublisherService;
    private final SalesQueryService salesQueryService;
    private final ExternalCustomerAccountService externalCustomerAccountService;
    private final ExternalProcurementService externalProcurementService;

    @Autowired
    public OrderService(OrderRepository orderRepository, SalesEventPublisherService salesEventPublisherService, SalesQueryService salesQueryService, ExternalCustomerAccountService externalCustomerAccountService, ExternalProcurementService externalProcurementService) {
        this.orderRepository = orderRepository;
        this.salesQueryService = salesQueryService;
        this.salesEventPublisherService = salesEventPublisherService;
        this.externalCustomerAccountService = externalCustomerAccountService;
        this.externalProcurementService = externalProcurementService;
    }
    public Order addOrder(Order order) {
        Product product = externalProcurementService.checkProductQuantity(order);
        if (product == null) {
            return null;
        }
        order = orderRepository.save(order);
        externalCustomerAccountService.putOrderInCustomer(order);
        order.setStatus("Created");
        SalesTransportEvent event = new SalesTransportEvent(new SalesTransportEventData("Order Created", LocalDateTime.now(), order.getId(), order.getCustomerId(), order.getProductName(), order.getQuantity()));
        salesEventPublisherService.handleSalesTransportEvent(event);
        return orderRepository.save(order);
    }
    public Order shipOrder(Long id) {
        Order order = salesQueryService.getOrderDetails(id);
        if (order != null) {
            order.setStatus("Shipped");
            orderRepository.save(order);
            SalesTransportEvent event = new SalesTransportEvent(new SalesTransportEventData("Order Shipped", LocalDateTime.now(), order.getId(), order.getCustomerId(), order.getProductName(), order.getQuantity()));
            salesEventPublisherService.handleSalesTransportEvent(event);
            return order;
        }
        return null;
    }

    public Order receivedOrder(Long id) {
        Order order = salesQueryService.getOrderDetails(id);
        if (order != null) {
            order.setStatus("Received");
            orderRepository.save(order);
            externalCustomerAccountService.removeOrderFromCustomer(order);
            SalesTransportEvent event = new SalesTransportEvent(new SalesTransportEventData("Order Received", LocalDateTime.now(), order.getId(), order.getCustomerId(), order.getProductName(), order.getQuantity()));
            salesEventPublisherService.handleSalesTransportEvent(event);
            return order;
        }
        return null;
    }
}
