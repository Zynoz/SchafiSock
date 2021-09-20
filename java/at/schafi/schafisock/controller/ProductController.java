/* (C)2021 */
package at.schafi.schafisock.controller;

import at.schafi.schafisock.model.Product;
import at.schafi.schafisock.service.api.ProductService;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    @GetMapping(value = {"/", "/list", "/all"})
    public @NotNull Iterable<Product> getProducts() {
        logger.info("Retrieving all products");
        return productService.getAllProducts();
    }

    @GetMapping(value = "/{id}")
    public Product getById(@PathVariable Long id) {
        logger.info("Retrieving Product with id {}", id);
        return productService.getProduct(id);
    }
}
