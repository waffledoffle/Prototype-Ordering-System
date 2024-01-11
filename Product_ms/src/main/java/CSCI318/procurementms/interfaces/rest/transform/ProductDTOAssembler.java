package CSCI318.procurementms.interfaces.rest.transform;

import CSCI318.procurementms.domain.model.aggregates.Product;
import CSCI318.procurementms.interfaces.rest.dto.ProductDTO;

public class ProductDTOAssembler {
    public static ProductDTO toDTOfromClass(Product product) {
        ProductDTO productDto = new ProductDTO();
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDetails().getDescription());
        productDto.setStock(product.getStock());
        return productDto;
    }
}
