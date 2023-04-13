package uz.aim.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.aim.orderservice.dtos.OrderRequest;
import uz.aim.orderservice.services.OrderService;

/**
 * @author : Abbosbek Murodov
 * @since : 12/04/23 / 01:08
 * Project : order-service / IntelliJ IDEA
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/place")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order placed successfully";
    }
}
