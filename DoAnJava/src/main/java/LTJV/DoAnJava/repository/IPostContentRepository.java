package LTJV.DoAnJava.repository;

import LTJV.DoAnJava.Entity.PostContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostContentRepository extends JpaRepository<PostContent,Long> {
}
