package CSCI318.customerAccountms.domain.model.aggregates;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.domain.AbstractAggregateRoot;


@Entity
@Table(name = "product_order")
public class Order extends AbstractAggregateRoot<Order> {
    @GeneratedValue
    @Id
    private Long id;

    private String supplier;
    private String productName;
    private int quantity;
    private Long customerId;
    private String status;

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String sup) {
        supplier = sup;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quant) {
        quantity = quant;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
