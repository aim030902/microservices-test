package uz.aim.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uz.aim.productservice.domains.Product;

/**
 * @author : Abbosbek Murodov
 * @since : 11/04/23 / 18:14
 * Project : product-service / IntelliJ IDEA
 */

public interface ProductRepository extends MongoRepository<Product, String> {
}
