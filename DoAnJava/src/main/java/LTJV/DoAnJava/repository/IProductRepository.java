package LTJV.DoAnJava.repository;

import LTJV.DoAnJava.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {

}
