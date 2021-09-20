/* (C)2021 */
package at.schafi.schafisock.service.api;

import at.schafi.schafisock.model.Order;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface OrderService {

    @NotNull
    Iterable<Order> getAllOrders();

    Order create(@NotNull(message = "The order cannot be null.") @Valid Order order);

    Order update(@NotNull(message = "The order cannot be null.") @Valid Order order);
}
