package CSCI318.salesms.domain.model.aggregates;
import javax.persistence.Entity;
import javax.persistence.Embedded;
import javax.persistence.Id;

import org.springframework.data.domain.AbstractAggregateRoot;

import CSCI318.salesms.domain.model.valueObjects.ProductDetail;

@Entity
public class Product extends AbstractAggregateRoot<Product> {
    @Id
    private String name;

    private String productCategory;
    private double price;
    private int quantity;
    private String stock;

    @Embedded
    private ProductDetail details;

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String category) {
        productCategory = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductDetail getDetails() {
        return details;
    }

    public void setDetails(ProductDetail details) {
        this.details = details;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}