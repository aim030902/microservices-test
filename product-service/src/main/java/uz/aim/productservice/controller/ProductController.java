package uz.aim.productservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.aim.productservice.domains.Product;
import uz.aim.productservice.dtos.ProductRequest;
import uz.aim.productservice.dtos.ProductResponse;
import uz.aim.productservice.service.ProductService;

import java.util.List;

/**
 * @author : Abbosbek Murodov
 * @since : 11/04/23 / 18:23
 * Project : product-service / IntelliJ IDEA
 */

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody ProductRequest request) {
        productService.save(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAll() {
        return productService.getAll();
    }
}
