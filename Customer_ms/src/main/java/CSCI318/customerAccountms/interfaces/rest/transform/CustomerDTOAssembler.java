package CSCI318.customerAccountms.interfaces.rest.transform;

import CSCI318.customerAccountms.domain.model.aggregates.Customer;
import CSCI318.customerAccountms.interfaces.rest.dto.CustomerDTO;

public class CustomerDTOAssembler {
    
    
    public static CustomerDTO toDTOfromClass(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCompanyName(customer.getCompanyName());
        customerDTO.setContact(customer.getContact());
        customerDTO.setCustomerOrders(customer.getCustomerOrders());
        customerDTO.setCountry(customer.getCountry());
        return customerDTO;
    }
}
