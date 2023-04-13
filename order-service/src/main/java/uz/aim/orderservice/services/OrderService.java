package uz.aim.orderservice.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import uz.aim.orderservice.domains.Order;
import uz.aim.orderservice.domains.OrderLineItems;
import uz.aim.orderservice.dtos.InventoryResponse;
import uz.aim.orderservice.dtos.OrderLineItemsDTO;
import uz.aim.orderservice.dtos.OrderRequest;
import uz.aim.orderservice.repository.OrderRepository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author : Abbosbek Murodov
 * @since : 12/04/23 / 11:02
 * Project : order-service / IntelliJ IDEA
 */

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClient;

    public void placeOrder(@NonNull OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDTOList().stream().map(this::mapToDTO).toList();
        order.setOrderLineItems(orderLineItems);
        List<String> skuCodes = order.getOrderLineItems().stream().map(OrderLineItems::getSkuCode).toList();
        InventoryResponse[] inventoryResponses = webClient.build().get()
                .uri("http://inventory-service/api/inventory", uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();
        if (inventoryResponses != null) {
            boolean allProductsInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);
            if (allProductsInStock) {
                orderRepository.save(order);
            }
            else {
                throw new IllegalArgumentException("Product is in not stock, try again later !");
            }
        }
        else {
            throw new IllegalArgumentException("Error ...");
        }

    }

    private OrderLineItems mapToDTO(OrderLineItemsDTO orderLineItemsDTO) {
        return OrderLineItems.builder()
                .skuCode(orderLineItemsDTO.getSkuCode())
                .quantity(orderLineItemsDTO.getQuantity())
                .price(orderLineItemsDTO.getPrice())
                .build();
    }
}
