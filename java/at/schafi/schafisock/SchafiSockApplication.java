/* (C)2021 */
package at.schafi.schafisock;

import at.schafi.schafisock.model.Product;
import at.schafi.schafisock.service.api.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SchafiSockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchafiSockApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(
                    new Product(1L, "Socke Grau", "", 300.00, "http://placehold.it/200x100"));
            productService.save(
                    new Product(2L, "Socke Rot", "", 200.00, "http://placehold.it/200x100"));
            productService.save(
                    new Product(3L, "Socke Schwarz", "", 100.00, "http://placehold.it/200x100"));
            productService.save(
                    new Product(4L, "Socke Grün", "", 5.00, "http://placehold.it/200x100"));
            productService.save(
                    new Product(5L, "Socke Blau", "", 3.00, "http://placehold.it/200x100"));
            productService.save(
                    new Product(6L, "Socke Gelb", "", 500.00, "http://placehold.it/200x100"));
            productService.save(
                    new Product(7L, "Socke Weiß", "", 30.00, "http://placehold.it/200x100"));
        };
    }
}
