package CSCI318.salesms.application.internal.outboundServices.acl;

import CSCI318.salesms.domain.model.aggregates.Customer;
import CSCI318.salesms.domain.model.aggregates.Order;

import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExternalCustomerAccountService {
    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    public Customer getCustomerById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "http://localhost:8080/customers/";
        Customer customer = new Customer();
        customer = restTemplate.getForObject(url + id, Customer.class);
        return customer;
    }

    public void putOrderInCustomer(Order order) {
        String url = "http://localhost:8080/customers/" + order.getCustomerId() + "/add";
        restTemplate.put(url, order);
    }

    public void removeOrderFromCustomer(Order order) {
        final String url = "http://localhost:8080/customers/" + order.getCustomerId() + "/orderRemove";
        restTemplate.put(url, order.getId());
    }
}
