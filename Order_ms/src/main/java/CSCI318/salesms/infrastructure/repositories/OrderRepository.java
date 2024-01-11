package CSCI318.salesms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CSCI318.salesms.domain.model.aggregates.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
