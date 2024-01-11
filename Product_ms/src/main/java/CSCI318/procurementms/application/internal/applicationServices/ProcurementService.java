package CSCI318.procurementms.application.internal.applicationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CSCI318.procurementms.application.internal.queryServices.ProcurementQueryService;
import CSCI318.procurementms.domain.model.aggregates.Product;
import CSCI318.procurementms.domain.model.valueObjects.ProductDetail;
import CSCI318.procurementms.infrastructure.repositories.ProductRepository;


@Service
public class ProcurementService {
        
    private final ProductRepository productRepository;
    private final ProcurementQueryService procurementQueryService;
    
    @Autowired
    public ProcurementService(ProductRepository productRepository, ProcurementQueryService procurementQueryService) {
        this.productRepository = productRepository;
        this.procurementQueryService = procurementQueryService;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(String name, Product product) {
         Product product1 = procurementQueryService.getProduct(name);
        if (product1 != null) {
            product1.setProductCategory(product.getProductCategory());
            product1.setPrice(product.getPrice());
            product1.setQuantity(product.getQuantity());
            product1.setDetails(product.getDetails());
            return productRepository.save(product1);
        }
        return null;
    }

    public Product updateProductCategory(String name, String category) {
         Product product1 = procurementQueryService.getProduct(name);
        if (product1 != null) {
            product1.setProductCategory(category);
            return productRepository.save(product1);
        }
        return null;
    }

    public Product updateProductPrice(String name, double price) {
        Product product1 = procurementQueryService.getProduct(name);
        if (product1 != null) {
            product1.setPrice(price);
            return productRepository.save(product1);
        }
        return null;
    }

    public void removeProduct(String name) {
        productRepository.deleteById(name);
    }

    public Product updateProductDetails(String name, ProductDetail details) {
        Product product = productRepository.findById(name).orElseThrow(RuntimeException::new);
        product.setDetails(details);
        return productRepository.save(product);
    }
}
