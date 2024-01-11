package CSCI318.customerAccountms.interfaces.rest.dto;

import java.util.List;

import CSCI318.customerAccountms.domain.model.valueObjects.Contact;

import java.util.ArrayList;

public class CustomerDTO {
    private String companyName;
    private Contact contact;
    private String country;
    List<Long> customerOrders = new ArrayList<>();

    public CustomerDTO() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Long> getCustomerOrders(){
        return customerOrders;
    }

    public void addCustomerOrder(Long orderId){
        this.customerOrders.add(orderId);
    }

    public void setCustomerOrders(List<Long> customerOrders){
        this.customerOrders = customerOrders;
    }

    public void removeCustomerOrder(Long orderId){
        this.customerOrders.remove(orderId);
    }
}
