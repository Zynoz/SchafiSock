package at.schafi.schafisock.repository;

import at.schafi.schafisock.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
