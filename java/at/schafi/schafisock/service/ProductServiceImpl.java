/* (C)2021 */
package at.schafi.schafisock.service;

import at.schafi.schafisock.exception.ResourceNotFoundException;
import at.schafi.schafisock.model.Product;
import at.schafi.schafisock.repository.ProductRepository;
import at.schafi.schafisock.service.api.ProductService;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
