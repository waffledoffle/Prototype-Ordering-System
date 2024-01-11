package CSCI318.salesms.application.internal.queryServices;

import CSCI318.salesms.domain.model.aggregates.Order;
import CSCI318.salesms.infrastructure.repositories.OrderRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SalesQueryService {
    private final OrderRepository orderRepository;

    public SalesQueryService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderDetails(Long id) {
        return orderRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
