package CSCI318.customerAccountms.application.internal.applicationServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CSCI318.customerAccountms.application.internal.domainServices.CustomerService;
import CSCI318.customerAccountms.application.internal.queryServices.CustomerAccountQueryService;
import CSCI318.customerAccountms.domain.model.aggregates.Customer;
import CSCI318.customerAccountms.domain.model.valueObjects.Contact;
import CSCI318.customerAccountms.infrastructure.repositories.CustomerRepository;


@Service
public class CustomerAccountService {
    
    private CustomerRepository customerRepository;
    CustomerAccountQueryService customerAccountQueryService;
    
    @Autowired
    public CustomerAccountService(CustomerRepository customerRepository, CustomerAccountQueryService customerAccountQueryService) {
        this.customerRepository = customerRepository;
        this.customerAccountQueryService = customerAccountQueryService;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomerDetails(Long id, Customer customerDetails) {
        Customer customer = customerAccountQueryService.getCustomerDetails(id);
        if (customer != null) {
            customer.setCompanyName(customerDetails.getCompanyName());
            customer.setAddress(customerDetails.getAddress());
            customer.setCountry(customerDetails.getCountry());
            customer.setContact(customerDetails.getContact());
            customer.setCustomerOrders(customerDetails.getCustomerOrders());
            return customerRepository.save(customer);
        }
        return null;
    }

    public Customer updateCustomerCompanyName(Long id, String company) {
        Customer customer = customerAccountQueryService.getCustomerDetails(id);
        if (customer != null) {
            customer.setCompanyName(company);
            return customerRepository.save(customer);
        }
        return null;
    }

    public Customer updateCustomerAddress(Long id, String address) {
        Customer customer = customerAccountQueryService.getCustomerDetails(id);
        if (customer != null) {
            customer.setAddress(address);
            return customerRepository.save(customer);
        }
        return null;
    }

    public Customer updateCustomerCountry(Long id, String country) {
        Customer customer = customerAccountQueryService.getCustomerDetails(id);
        if (customer != null) {
            customer.setCountry(country);
            return customerRepository.save(customer);
        }
        return null;
    }
    public void removeCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer updateCustomerContact(Long id, Contact details) {
        Customer customer1 = customerAccountQueryService.getCustomerDetails(id);
        if (customer1 != null) {
            customer1.setContact(details);
            return customerRepository.save(customer1);
        }
        return null;
    }

    public Customer addCustomerOrder(Long id, Long orderId) {
        Customer customer = customerAccountQueryService.getCustomerDetails(id);
        if (customer != null) {
            CustomerService.customerLoyaltyreward(customer);
            if (customer.getCustomerOrders().contains(orderId)) {
                return customer;
            }
            customer.addCustomerOrder(orderId);
            return customerRepository.save(customer);
        }
        return null;
    }

    public Customer removeCustomerOrder(Long id, Long orderId){
        Customer customer = customerAccountQueryService.getCustomerDetails(id);
        if (customer != null) {
            customer.removeCustomerOrder(orderId);
            return customerRepository.save(customer);
        }
        return null;
    }
}
