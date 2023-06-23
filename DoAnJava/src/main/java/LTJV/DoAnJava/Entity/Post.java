package LTJV.DoAnJava.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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

    @Lob
    @Column(name = "title")
    @Nationalized
    @NotEmpty(message = "Title must not be empty")
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

    @Lob
    @Column(name = "coverImage")
    private String coverImage;

    @Column(name = "date",nullable = true)
    private Date date;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<PostContent> contents = new ArrayList<>();

}
