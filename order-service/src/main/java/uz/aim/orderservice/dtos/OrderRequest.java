package uz.aim.orderservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author : Abbosbek Murodov
 * @since : 12/04/23 / 10:55
 * Project : order-service / IntelliJ IDEA
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderRequest {
    private List<OrderLineItemsDTO> orderLineItemsDTOList;
}

