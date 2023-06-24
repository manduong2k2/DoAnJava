package LTJV.DoAnJava.Entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number")
    @NotNull(message = "Number is required")
    private long number;

    @Column(insertable=false, updatable=false)
    private long product_id;

    @ManyToOne
    @JoinColumn(name="product_id",referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="order_id",referencedColumnName = "id")
    private Order product_order;
    public static List<Item> fromJsonList(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, new TypeReference<List<Item>>(){});
    }
}
