package CSCI318.procurementms.infrastructure.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import CSCI318.procurementms.domain.model.aggregates.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    
    @Query("SELECT p FROM Product p WHERE p.name LIKE :prefix")
    List<Product> findByNameStartingWith(@Param("prefix") String prefix);
}
