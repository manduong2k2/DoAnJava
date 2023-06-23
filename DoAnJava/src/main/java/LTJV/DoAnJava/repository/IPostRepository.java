package LTJV.DoAnJava.repository;

import LTJV.DoAnJava.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post,Long> {
}
