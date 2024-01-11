package CSCI318.salesms.interfaces.rest.transform;

import CSCI318.salesms.domain.model.aggregates.Order;
import CSCI318.salesms.domain.model.aggregates.Product;
import CSCI318.salesms.domain.model.aggregates.Customer;
import CSCI318.salesms.interfaces.rest.dto.OrderDTO;
import CSCI318.salesms.application.internal.outboundServices.acl.ExternalCustomerAccountService;
import CSCI318.salesms.application.internal.outboundServices.acl.ExternalProcurementService;

public class OrderDTOAssembler {
    
    public static OrderDTO toDTOfromClass(Order order) {
        OrderDTO orderDto = new OrderDTO();
        orderDto.setSupplier(order.getSupplier());
        orderDto.setQuantity(order.getQuantity());
        orderDto.setStatus(order.getStatus());
        
        ExternalProcurementService externalProcurementService = new ExternalProcurementService();
        Product product = externalProcurementService.getProductById(order.getProductName());
        orderDto.setProduct(ProductDTOAssembler.toDTOfromClass(product));

        ExternalCustomerAccountService externalCustomerAccountService = new ExternalCustomerAccountService();
        Customer customer = externalCustomerAccountService.getCustomerById(order.getCustomerId());
        orderDto.setCustomer(CustomerDTOAssembler.toDTOfromClass(customer));

        return orderDto;
    }
}
