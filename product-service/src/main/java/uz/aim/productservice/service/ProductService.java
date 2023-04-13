package uz.aim.productservice.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.aim.productservice.domains.Product;
import uz.aim.productservice.dtos.ProductRequest;
import uz.aim.productservice.dtos.ProductResponse;
import uz.aim.productservice.repository.ProductRepository;

import java.util.List;

/**
 * @author : Abbosbek Murodov
 * @since : 11/04/23 / 18:26
 * Project : product-service / IntelliJ IDEA
 */

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    public void save(@NonNull ProductRequest request) {
        Product product = Product
                .builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToResponse).toList();
    }

    private ProductResponse mapToResponse(Product product) {
        return ProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
