package LTJV.DoAnJava.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.Nationalized;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    @NotEmpty(message = "Title must not be empty")
    @Size(max = 50, min = 1, message = "Title must be less than 50 characters")
    private String title;

    @Lob
    @Column(name = "intro")
    @Nationalized
    @NotEmpty(message = "Introduction must not be empty")
    private String intro;

    @Lob
    @Column(name = "ending")
    @Nationalized
    @NotEmpty(message = "Ending must not be empty")
    private String ending;

    @Column(name = "coverImage")
    @Size(max = 50, message = "coverImage must be less than 50 characters")
    private String coverImage;

    @Column(name = "date",nullable = true)
    private Date date;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<PostContent> contents = new ArrayList<>();

}
