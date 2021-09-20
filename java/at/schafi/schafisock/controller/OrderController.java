package at.schafi.schafisock.controller;

import at.schafi.schafisock.dto.OrderProductDto;
import at.schafi.schafisock.exception.ResourceNotFoundException;
import at.schafi.schafisock.model.Order;
import at.schafi.schafisock.model.OrderProduct;
import at.schafi.schafisock.model.OrderStatus;
import at.schafi.schafisock.service.api.OrderProductService;
import at.schafi.schafisock.service.api.OrderService;
import at.schafi.schafisock.service.api.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {

    ProductService productService;
    OrderService orderService;
    OrderProductService orderProductService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Order> list() {
        return this.orderService.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderForm form) {
        List<OrderProductDto> formDtos = form.getProductOrders();
        validateProductsExistence(formDtos);
        Order order = new Order();
        order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);

        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductDto dto : formDtos) {
            orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getProduct(dto.getProduct().getId()), dto.getQuantity())));
        }

        order.setOrderProducts(orderProducts);
        this.orderService.update(order);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/orders/{id}")
                .buildAndExpand(order.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);
        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }

    private void validateProductsExistence(List<OrderProductDto> orderProducts) {
        List<OrderProductDto> list = orderProducts.stream().filter(op -> Objects.isNull(productService.getProduct(op.getProduct().getId()))).collect(Collectors.toList());
        if (!list.isEmpty()) throw new ResourceNotFoundException("Product not found");
    }

    @Getter
    @Setter
    public static class OrderForm {

        private List<OrderProductDto> productOrders;
    }
}
