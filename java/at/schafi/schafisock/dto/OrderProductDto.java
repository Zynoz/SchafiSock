package at.schafi.schafisock.dto;

import at.schafi.schafisock.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProductDto {

    private Product product;
    private Integer quantity;
}
