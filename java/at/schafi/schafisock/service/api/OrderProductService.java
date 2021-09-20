package at.schafi.schafisock.service.api;

import at.schafi.schafisock.model.OrderProduct;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderProductService {
    OrderProduct create(@NotNull(message = "The products for the order cannot be null.") @Valid OrderProduct orderProduct);
}
