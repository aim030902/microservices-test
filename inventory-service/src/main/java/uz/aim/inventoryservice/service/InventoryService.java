package uz.aim.inventoryservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.aim.inventoryservice.dtos.InventoryResponse;
import uz.aim.inventoryservice.repository.InventoryRepository;

import java.util.List;

/**
 * @author : Abbosbek Murodov
 * @since : 12/04/23 / 11:46
 * Project : inventory-service / IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
         return inventoryRepository.findBySkuCodeIn(skuCode)
                .stream()
                .map(inventory ->
                    InventoryResponse
                           .builder()
                           .skuCode(inventory.getSkuCode())
                           .isInStock(inventory.getQuantity() > 0)
                           .build()
                ).toList();

    };


}
