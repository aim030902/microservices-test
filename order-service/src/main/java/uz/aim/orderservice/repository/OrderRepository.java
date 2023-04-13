package uz.aim.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.aim.orderservice.domains.Order;

/**
 * @author : Abbosbek Murodov
 * @since : 12/04/23 / 11:06
 * Project : order-service / IntelliJ IDEA
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
