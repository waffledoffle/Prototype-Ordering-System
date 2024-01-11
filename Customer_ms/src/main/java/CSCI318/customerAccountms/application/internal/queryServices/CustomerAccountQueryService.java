package CSCI318.customerAccountms.application.internal.queryServices;

import java.util.List;

import CSCI318.customerAccountms.domain.model.aggregates.Customer;
import CSCI318.customerAccountms.infrastructure.repositories.CustomerRepository;

import org.springframework.stereotype.Service;

@Service
public class CustomerAccountQueryService {
    private final CustomerRepository customerRepository;
    
    public CustomerAccountQueryService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public Customer getCustomerDetails(Long id) {
        return customerRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
