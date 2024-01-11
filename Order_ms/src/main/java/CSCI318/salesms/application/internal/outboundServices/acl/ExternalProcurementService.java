package CSCI318.salesms.application.internal.outboundServices.acl;

import CSCI318.salesms.domain.model.aggregates.Product;
import CSCI318.salesms.domain.model.aggregates.Order;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExternalProcurementService {
    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    public Product getProductById(String id) {
        final String url = "http://localhost:8082/products/";
        Product product = new Product();
        product = restTemplate.getForObject(url + id, Product.class);
        return product;
    }

    public Product checkProductQuantity(Order order) {
        String url = "http://localhost:8082/products/" + order.getProductName() + "/check";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Integer> requestEntity = new HttpEntity<>(order.getQuantity(), headers);

        ResponseEntity<Product> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Product.class);
        Product product = responseEntity.getBody();
        return product;
    }
}
