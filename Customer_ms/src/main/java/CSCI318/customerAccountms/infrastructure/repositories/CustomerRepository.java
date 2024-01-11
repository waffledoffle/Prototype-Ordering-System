package CSCI318.customerAccountms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CSCI318.customerAccountms.domain.model.aggregates.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
