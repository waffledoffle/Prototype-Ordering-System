package CSCI318.salesms.interfaces.rest.transform;

import CSCI318.salesms.domain.model.aggregates.Customer;
import CSCI318.salesms.interfaces.rest.dto.CustomerDTO;

public class CustomerDTOAssembler {

    
    public static CustomerDTO toDTOfromClass(Customer customer) {
        CustomerDTO customerDto = new CustomerDTO();
        customerDto.setCName(customer.getCompanyName());
        customerDto.setName(customer.getContact().getName());
        customerDto.setCountry(customer.getCountry());
        customerDto.setEmail(customer.getContact().getEmail());
        return customerDto;
    }
}
