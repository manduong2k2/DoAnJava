package LTJV.DoAnJava.Entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.annotations.Nationalized;

import java.util.List;

@Data
@Entity
@Table(name = "post_content")
public class PostContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    @Column(name = "subheading")
    @Nationalized
    @NotEmpty(message = "Subheading must not be empty")
    private String subheading;

    @Lob
    @Column(name = "content")
    @Nationalized
    @NotEmpty(message = "content must not be empty")
    private String content;

    @ManyToOne
    @JoinColumn(name="post_id",referencedColumnName = "id")
    private Post post;
    public static List<PostContent> fromJsonList(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, new TypeReference<List<PostContent>>(){});
    }
}
