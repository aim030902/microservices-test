package uz.aim.inventoryservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.aim.inventoryservice.dtos.InventoryResponse;
import uz.aim.inventoryservice.service.InventoryService;

import java.util.List;

/**
 * @author : Abbosbek Murodov
 * @since : 12/04/23 / 11:43
 * Project : inventory-service / IntelliJ IDEA
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public List<InventoryResponse> isInStock(@RequestParam(name = "skuCode") List<String> skuCode) {
        return inventoryService.isInStock(skuCode);
    }
}
