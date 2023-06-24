package LTJV.DoAnJava.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Acc")
public class Acc {
    @Id
    @NotBlank(message = "Username is required")
    @Size(max = 255, message = "Username must be less than 50 characters")
    @Column(name = "username",length = 255,nullable = false)
    private String username;
    @Column(name = "password", length = 250, nullable = false)
    @NotBlank(message = "Password is required")
    private String password;
    @Column(name = "email", length = 50)
    @Size(max = 50, message = "Email must be less than 50 characters")
    private String email;
    @Column(name = "name", length = 50, nullable = false)
    @Size(max = 50, message = "Your name must be less than 50 characters")
    @NotBlank(message = "Your name is required")
    private String name;

    @ManyToMany
    @JoinTable(name = "acc_role",
            joinColumns = @JoinColumn(name = "acc_name"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany (mappedBy = "acc", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Order> orders=new ArrayList<>();

}
