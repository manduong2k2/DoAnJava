package LTJV.DoAnJava.repository;

import LTJV.DoAnJava.Entity.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IPostRepository extends JpaRepository<Post,Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO post_product (post_id, product_id)" + "VALUES(?1,?2)",nativeQuery = true)
    void addProductToPost(Long PostId, Long ProductId);
}
