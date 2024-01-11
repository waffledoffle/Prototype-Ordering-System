package CSCI318.procurementms.application.internal.queryServices;

import java.util.List;

import org.springframework.stereotype.Service;

import CSCI318.procurementms.domain.model.aggregates.Product;
import CSCI318.procurementms.infrastructure.repositories.ProductRepository;

@Service
public class ProcurementQueryService {
    private final ProductRepository productRepository;

    public ProcurementQueryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(String name) {
        return productRepository.findById(name).orElseThrow(RuntimeException::new);
    }

    public List<Product> getProductsBy(String s) {
        return productRepository.findByNameStartingWith(s + "%");
    }
}
