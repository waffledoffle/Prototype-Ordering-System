package CSCI318.procurementms.application.internal.domainServices;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CSCI318.procurementms.application.internal.outboundServices.ProcurementEventPublisherService;
import CSCI318.procurementms.application.internal.queryServices.ProcurementQueryService;
import CSCI318.procurementms.domain.model.aggregates.Product;
import CSCI318.procurementms.infrastructure.repositories.ProductRepository;
import CSCI318.shareddomain.events.ProcurementStockEvent;
import CSCI318.shareddomain.events.ProcurementStockEventData;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;
    private final ProcurementEventPublisherService procurementEventPublisherService;
    private final ProcurementQueryService procurementQueryService;
    
    @Autowired
    public ProductService(ProductRepository productRepository, ProcurementEventPublisherService procurementEventPublisherService, ProcurementQueryService procurementQueryService) {
        this.productRepository = productRepository;
        this.procurementEventPublisherService = procurementEventPublisherService;
        this.procurementQueryService = procurementQueryService;
    }
    
    public Product updateProductQuantity(String name, int quantity) {
        Product product1 = procurementQueryService.getProduct(name);
        if (product1 != null) {
            product1.setQuantity(quantity);
            if (quantity > 0) {
                updateProductStock(name, "In stock");
            }
            else {
                updateProductStock(name, "Out of stock");
            }
            return productRepository.save(product1);
        }
        return null;
    }

    public Product decreaseProductQuantity(String name, int quantity) {
        Product product1 = procurementQueryService.getProduct(name);
        if (product1 == null) {
            return null;
        }
        if (product1.getQuantity() >= quantity) {
            product1.setQuantity(product1.getQuantity() - quantity);
            return productRepository.save(product1);
        }
        return null;
    }

    public Product updateProductStock(String name, String stock) {
        Product product1 = procurementQueryService.getProduct(name);
        if (product1 != null) {
            product1.setStock(stock);
            if (stock.equals("In stock")) {
                ProcurementStockEvent event = new ProcurementStockEvent(new ProcurementStockEventData("Product in stock", LocalDateTime.now(), name));
                procurementEventPublisherService.handleProcurementStockEvent(event);
            }
            else if (stock.equals("Out of stock")) {
                ProcurementStockEvent event = new ProcurementStockEvent(new ProcurementStockEventData("Product Out of stock", LocalDateTime.now(), name));
                procurementEventPublisherService.handleProcurementStockEvent(event);
                updateProductQuantity(product1.getName(), 10);
                return null;
            }
            return productRepository.save(product1);
        }
        return null;
    }
}
