package LTJV.DoAnJava.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotEmpty(message = "Name must not be empty")
    @Size(max = 50, min = 1, message = "Name must be less than 50 characters")
    private String name;

    @Column(name = "price")
    @NotNull(message = "Price is required")
    private Double price;

    @Column(name = "image")
    @Size(max = 200, message = "image must be less than 200 characters")
    private String image;

    @Column(name = "uses")
    @NotEmpty(message = "Uses must not be empty")
    @Size(max = 100, min = 1, message = "Uses must be less than 100 characters")
    private String uses;

    @ManyToOne
    @JoinColumn(name="provider_id",referencedColumnName = "id")
    private Provider provider;

    @Column(name = "expiration")
    @NotNull(message = "Expiration is required")
    private Date expiration;

}
