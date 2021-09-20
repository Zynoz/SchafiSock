package at.schafi.schafisock.repository;

import at.schafi.schafisock.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
