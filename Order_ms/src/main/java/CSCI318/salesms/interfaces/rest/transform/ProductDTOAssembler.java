package CSCI318.salesms.interfaces.rest.transform;

import CSCI318.salesms.domain.model.aggregates.Product;
import CSCI318.salesms.interfaces.rest.dto.ProductDTO;

public class ProductDTOAssembler {
    public static ProductDTO toDTOfromClass(Product product) {
        ProductDTO productDto = new ProductDTO();
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        return productDto;
    } 
}
