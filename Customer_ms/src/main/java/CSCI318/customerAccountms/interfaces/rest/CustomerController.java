package CSCI318.customerAccountms.interfaces.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import CSCI318.customerAccountms.application.internal.applicationServices.CustomerAccountService;
import CSCI318.customerAccountms.application.internal.outboundServices.acl.ExternalSalesService;
import CSCI318.customerAccountms.application.internal.queryServices.CustomerAccountQueryService;
import CSCI318.customerAccountms.domain.model.aggregates.Customer;
import CSCI318.customerAccountms.domain.model.aggregates.Order;
import CSCI318.customerAccountms.domain.model.valueObjects.Contact;
import CSCI318.customerAccountms.interfaces.rest.dto.CustomerDTO;
import CSCI318.customerAccountms.interfaces.rest.dto.OrderDTO;
import CSCI318.customerAccountms.interfaces.rest.transform.CustomerDTOAssembler;

import java.util.stream.Collectors;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    private final CustomerAccountService customerAccountService;
    private final CustomerAccountQueryService customerAccountQueryService;
    private final ExternalSalesService externalSalesService;
    
    @Autowired
    public CustomerController(CustomerAccountService customerAccountService, CustomerAccountQueryService customerAccountQueryService, ExternalSalesService externalSalesService) {
        this.customerAccountService = customerAccountService;
        this.customerAccountQueryService = customerAccountQueryService;
        this.externalSalesService = externalSalesService;

    }

    @PostMapping
    CustomerDTO createCustomer(@RequestBody Customer newCustomer) {
        newCustomer = customerAccountService.addCustomer(newCustomer);
        return CustomerDTOAssembler.toDTOfromClass(newCustomer);
    }

    // Calls upon dto to find all customers
    @GetMapping
    List<CustomerDTO> all() {
        return customerAccountQueryService.getAllCustomers()
            .stream()
            .map(customer -> {
                return CustomerDTOAssembler.toDTOfromClass(customer);
            }).collect(Collectors.toList());
    }

    //Calls upon dto to get a customer by id
    @GetMapping("/{id}")
    CustomerDTO getCustomerById(@PathVariable Long id) {
        Customer customer = customerAccountQueryService.getCustomerDetails(id);
        return CustomerDTOAssembler.toDTOfromClass(customer);
    }

    @GetMapping("/{id}/orders")
    List<OrderDTO> getCustomerOrders(@PathVariable Long id, Long orderId){
        return externalSalesService.getCustomerOrders(id, orderId);
    }

    //updates the customer through dto
    @PutMapping("/{id}")
    String updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer newCustomer = customerAccountService.updateCustomerDetails(id, customer);
        if (newCustomer != null) {
            return "Customer succesfully updated";
        }
        return "Customer could not be found";
    }

    @PutMapping("/{id}/company")
    String updateCustomerCompanyName(@PathVariable Long id, @RequestBody String companyName) {
        Customer newCustomer = customerAccountService.updateCustomerCompanyName(id, companyName);
        if (newCustomer != null) {
            return "Customer has been updated with Company name: " + companyName;
        }
        return "Customer could not be found";
    }

    @PutMapping("/{id}/address")
    String updateCustomerAddress(@PathVariable Long id, @RequestBody String address) {
        Customer newCustomer = customerAccountService.updateCustomerAddress(id, address);
        if (newCustomer != null) {
            return "Customer has been updated with address: " + address;
        }
        return "Customer could not be found";
    }

    @PutMapping("/{id}/country")
    String updateCustomerCountry(@PathVariable Long id, @RequestBody String country) {
        Customer newCustomer = customerAccountService.updateCustomerCountry(id, country);
        if (newCustomer != null) {
            return "Customer has been updated with country: " + country;
        }
        return "Customer could not be found";
    }

    @PutMapping("/{id}/add")
    String addCustomerOrder(@PathVariable Long id, @RequestBody Order order) {
        Customer newCustomer = customerAccountService.addCustomerOrder(id, order.getId());
        if (newCustomer != null) {
            return "Customer has been updated with order: " + order.getId();
        }
        return "Customer could not be found";
    }

    @DeleteMapping("/{id}")
    String removeCustomer(@PathVariable Long id) {
        customerAccountService.removeCustomer(id);
        return "Customer has been removed";
    }

    @PutMapping("/{id}/orderRemove")
    void removeOrder(@PathVariable Long id, @RequestBody Long orderId) {
        customerAccountService.removeCustomerOrder(id, orderId);
    }

    @PutMapping("/{id}/contact")
    String updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        Customer newCustomer = customerAccountService.updateCustomerContact(id, contact);
        if (newCustomer != null) {
            return "Customer has been updated with Contact: " + contact.toString();
        }
        return "Customer could not be found";
    }

}