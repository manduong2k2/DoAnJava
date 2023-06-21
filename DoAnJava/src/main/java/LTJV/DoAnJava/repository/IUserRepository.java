package LTJV.DoAnJava.repository;

import LTJV.DoAnJava.Entity.Acc;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository  extends JpaRepository<Acc,Long> {
    @Query(value = "SELECT * FROM acc WHERE username= ?1",nativeQuery = true)
    Acc findByUserName(String username);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO acc_role (acc_name, role_id)" + "VALUES(?1,?2)",nativeQuery = true)
    void addRoleToUser(String userName, Long roleId);
    @Query (value = "SELECT r.name FROM role r INNER JOIN acc_role ur " +
            "ON r.id = ur.role_id WHERE ur.acc_name = ?1", nativeQuery= true)
    String[] getRolesOfUser (String username);

}
