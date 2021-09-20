/* (C)2021 */
package at.schafi.schafisock.service.api;

import at.schafi.schafisock.model.OrderProduct;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface OrderProductService {
    OrderProduct create(
            @NotNull(message = "The products for the order cannot be null.") @Valid
                    OrderProduct orderProduct);
}
