package CSCI318.customerAccountms.application.internal.domainServices;
import CSCI318.customerAccountms.domain.model.aggregates.Customer;

public class CustomerService {
    
    public static void customerLoyaltyreward(Customer customer) {
        if((customer.getCustomerOrders().size() + 1) % 3 == 0)
        {
            System.out.println("For being such a loyal customer this order is discounted!");
        }
        else {
            System.out.println("No discount applied");
        }
    }
}
