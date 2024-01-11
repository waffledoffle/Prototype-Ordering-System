package CSCI318.customerAccountms.interfaces.rest.dto;

//import CSCI318.Controller.DTO.ProductDTO;

public class OrderDTO {

    private ProductDTO productDTO;
    private int quantity;
    private String status;

    public OrderDTO() {

    }

    public ProductDTO getProduct() {
        return productDTO;
    }

    public void setProduct(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quant) {
        quantity = quant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
