package LTJV.DoAnJava.repository;

import LTJV.DoAnJava.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepository extends JpaRepository<Item,Long> {
}
