package uz.aim.productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author : Abbosbek Murodov
 * @since : 11/04/23 / 18:25
 * Project : product-service / IntelliJ IDEA
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
}
