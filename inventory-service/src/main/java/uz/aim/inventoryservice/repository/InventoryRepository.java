package uz.aim.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.aim.inventoryservice.domains.Inventory;

import java.util.List;
import java.util.Optional;

/**
 * @author : Abbosbek Murodov
 * @since : 12/04/23 / 11:43
 * Project : inventory-service / IntelliJ IDEA
 */

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long > {
    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
