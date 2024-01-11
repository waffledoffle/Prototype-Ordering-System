package CSCI318.procurementms.interfaces.rest;
import org.springframework.web.bind.annotation.*;

import CSCI318.procurementms.application.internal.applicationServices.ProcurementService;
import CSCI318.procurementms.application.internal.domainServices.ProductService;
import CSCI318.procurementms.application.internal.queryServices.ProcurementQueryService;
import CSCI318.procurementms.domain.model.aggregates.Product;
import CSCI318.procurementms.domain.model.valueObjects.ProductDetail;
import CSCI318.procurementms.interfaces.rest.dto.ProductDTO;
import CSCI318.procurementms.interfaces.rest.transform.ProductDTOAssembler;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProcurementService procurementService;
    private final ProcurementQueryService procurementQueryService;
    private final ProductService productService;

    public ProductController(ProcurementService procurementService, ProcurementQueryService procurementQueryService, ProductService productService) {
        this.procurementService = procurementService;
        this.procurementQueryService = procurementQueryService;
        this.productService = productService;
    }

    @PostMapping
    ProductDTO createProduct(@RequestBody Product product) {
        Product newProduct = procurementService.addProduct(product);
        return ProductDTOAssembler.toDTOfromClass(newProduct);
    }

    @GetMapping
    List<ProductDTO> all() {
        return procurementQueryService.getAllProducts()
                .stream()
                .map(product -> ProductDTOAssembler.toDTOfromClass(product))
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{name}")
    ProductDTO getProductByName(@PathVariable String name) {
        Product product = procurementQueryService.getProduct(name);
        return ProductDTOAssembler.toDTOfromClass(product);
    }

    @PutMapping("/{name}")
    String updateProduct(@PathVariable String name, @RequestBody Product product) {
        Product newProduct = procurementService.updateProduct(name, product);
        if (newProduct != null) {
            return "Product: "  + name + " has been updated with new details";
        }
        return "Product with name: " + name + " could not be found";
    }

    @PutMapping("/{name}/category")
    String updateProductCategory(@PathVariable String name, @RequestBody String productCategory) {
        Product newProduct = procurementService.updateProductCategory(name, productCategory);
        if (newProduct != null) {
            return "Product with name: " + name + " updated with new category: " + productCategory;
        }
        return "Product with name: " + name + " could not be found";
    }

    @PutMapping("/{name}/price")
    String updateProductPrice(@PathVariable String name, @RequestBody double price) {
        Product newProduct = procurementService.updateProductPrice(name, price);
        if (newProduct != null) {
            return "Product with name: " + name + " updated with new price: " + price;
        }
        return "Product with name: " + name + " could not be found";
    }

    @DeleteMapping("/{name}")
    String removeProduct(@PathVariable String name) {
        procurementService.removeProduct(name);
        return "Product with name: " + name + " has been removed";
    }
    
    @PutMapping("/{name}/details")
    String updateDetails(@PathVariable String name, @RequestBody ProductDetail details) {
        Product newProduct = procurementService.updateProductDetails(name, details);
        if (newProduct != null) {
            return "Product with name: " + name + " updated ProductDetails with new details";
        }
        return "Product with name: " + name + " could not be found";
    }

    @PutMapping("/{name}/quantity")
    String updateQuantity(@PathVariable String name, @RequestBody int quantity) {
        Product newProduct = productService.updateProductQuantity(name, quantity);
        if (newProduct != null) {
            return "Product with name: " + name + " updated with new quantity: " + quantity;
        }
        return "Product with name: " + name + " could not be found";
    }

    @PutMapping("/{name}/check")
    ProductDTO productCheck(@PathVariable String name, @RequestBody int quantity) {
        Product product = productService.decreaseProductQuantity(name, quantity);
        if (product == null) {
            return null;
        }
        return ProductDTOAssembler.toDTOfromClass(product);
    }

    @GetMapping("/searchBy/{string}")
    List<ProductDTO> searchProductsBy(@PathVariable String string) {
        return procurementQueryService.getProductsBy(string)
                .stream()
                .map(product -> ProductDTOAssembler.toDTOfromClass(product))
                .collect(Collectors.toList());
    }
}
