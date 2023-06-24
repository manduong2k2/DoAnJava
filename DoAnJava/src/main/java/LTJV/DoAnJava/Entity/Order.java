package LTJV.DoAnJava.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "product_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="acc_username",referencedColumnName = "username")
    private Acc acc;

    @Column(name = "date",nullable = true)
    private Date date;

    @Column(name = "total")
    @NotNull(message = "total is required")
    private Double total;

    @OneToMany (mappedBy = "product_order", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Item> items;
}
