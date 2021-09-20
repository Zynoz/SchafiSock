/* (C)2021 */
package at.schafi.schafisock.repository;

import at.schafi.schafisock.model.OrderProduct;
import at.schafi.schafisock.model.OrderProductPK;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {}
