package CSCI318.salesms.interfaces.rest.dto;
 
public class OrderDTO {
    private String supplier;
    private ProductDTO product;
    private int quantity;
    private CustomerDTO customer;
    private String status;

    public OrderDTO() {

    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String sup) {
        supplier = sup;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quant) {
        quantity = quant;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
