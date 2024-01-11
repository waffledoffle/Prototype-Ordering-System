package CSCI318.customerAccountms.application.internal.outboundServices.acl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;

import CSCI318.customerAccountms.domain.model.aggregates.Customer;
import CSCI318.customerAccountms.interfaces.rest.dto.OrderDTO;
import CSCI318.customerAccountms.application.internal.queryServices.CustomerAccountQueryService;

@Service
public class ExternalSalesService {
    @Autowired
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    CustomerAccountQueryService customerAccountQueryService;
    
    public List<OrderDTO> getCustomerOrders(Long id, Long orderId) {
        Customer customer = customerAccountQueryService.getCustomerDetails(id);
        if(customer != null){
            return customer.getCustomerOrders()
            .stream()
            .map(order -> {
                String url = "http://localhost:8081/orders/" + order;
                OrderDTO orderDTO = restTemplate.getForObject(url, OrderDTO.class);
                return orderDTO;
            }).collect(Collectors.toList());
        }
        return null;
    }
}
