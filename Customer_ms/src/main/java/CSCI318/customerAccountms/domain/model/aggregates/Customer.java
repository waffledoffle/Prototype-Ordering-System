package CSCI318.customerAccountms.domain.model.aggregates;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.data.domain.AbstractAggregateRoot;

import CSCI318.customerAccountms.domain.model.valueObjects.Contact;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends AbstractAggregateRoot<Customer> {
    
    @GeneratedValue
    @Id
    private Long id;
    private String companyName;
    private String address;
    private String country;

    @Column
    @ElementCollection(fetch = FetchType.EAGER, targetClass=Long.class)
    List<Long> customerOrders = new ArrayList<>();
    
    @Embedded
    private Contact contact;

    public Customer() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
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
