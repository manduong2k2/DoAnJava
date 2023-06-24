package LTJV.DoAnJava.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.Nationalized;

import java.sql.Date;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    @Nationalized
    @Column(name = "name")
    @NotEmpty(message = "Name must not be empty")
    private String name;

    @Column(name = "price")
    @NotNull(message = "Price is required")
    private Double price;

    @Column(name = "image")
    @Size(max = 200, message = "image must be less than 200 characters")
    private String image;

    @Column(name = "uses")
    @NotEmpty(message = "Uses must not be empty")
    @Size(max = 500, min = 1, message = "Uses must be less than 500 characters")
    private String uses;

    @ManyToOne
    @JoinColumn(name="provider_id",referencedColumnName = "id")
    private Provider provider;

    @Column(name = "expiration")
    @NotNull(message = "Expiration is required")
    private Date expiration;

}
