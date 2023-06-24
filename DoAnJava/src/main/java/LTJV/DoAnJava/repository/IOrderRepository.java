package LTJV.DoAnJava.repository;

import LTJV.DoAnJava.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order,Long> {
}
