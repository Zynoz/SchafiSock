package at.schafi.schafisock.controller;

import at.schafi.schafisock.model.Product;
import at.schafi.schafisock.service.api.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }
}
