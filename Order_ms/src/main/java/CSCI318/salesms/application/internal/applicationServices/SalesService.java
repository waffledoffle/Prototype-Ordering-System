package CSCI318.salesms.application.internal.applicationServices;

import java.time.LocalDateTime;

import CSCI318.salesms.application.internal.outboundServices.SalesEventPublisherService;
import CSCI318.salesms.application.internal.outboundServices.acl.ExternalCustomerAccountService;
import CSCI318.salesms.application.internal.outboundServices.acl.ExternalProcurementService;
import CSCI318.salesms.application.internal.queryServices.SalesQueryService;
import CSCI318.salesms.domain.model.aggregates.Order;
import CSCI318.salesms.domain.model.aggregates.Product;
import CSCI318.salesms.infrastructure.repositories.OrderRepository;
import CSCI318.shareddomain.events.SalesTransportEvent;
import CSCI318.shareddomain.events.SalesTransportEventData;

public class SalesService {
    private final OrderRepository orderRepository;
    private final SalesEventPublisherService salesEventPublisherService;
    private final SalesQueryService salesQueryService;
    private final ExternalProcurementService externalProcurementService;
    private final ExternalCustomerAccountService externalCustomerAccountService;

    public SalesService(OrderRepository orderRepository, SalesEventPublisherService salesEventPublisherService, SalesQueryService salesQueryService, ExternalProcurementService externalProcurementService, ExternalCustomerAccountService externalCustomerAccountService) {
        this.orderRepository = orderRepository;
        this.salesQueryService = salesQueryService;
        this.salesEventPublisherService = salesEventPublisherService;
        this.externalProcurementService = externalProcurementService;
        this.externalCustomerAccountService = externalCustomerAccountService;
    }
    

    public Order updateOrderDetails(Long id, Order orderDetails) {
        Order order = salesQueryService.getOrderDetails(id);
        if (order != null) {
            order.setProductName(orderDetails.getProductName());
            order.setQuantity(orderDetails.getQuantity());
            order.setSupplier(orderDetails.getSupplier());
            order.setCustomerId(orderDetails.getCustomerId());
            return orderRepository.save(order);
        }
        return null;
    }

    public void removeOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
