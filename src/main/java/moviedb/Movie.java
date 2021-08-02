package moviedb;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String country;
    private LocalDate release;
    private int length;
    @ElementCollection
    private List<Genre> genres = new ArrayList<>();
    @ElementCollection
    private List<Integer> rating = new ArrayList<>();
    @OneToMany(mappedBy = "movie")
    private List<Director> directors = new ArrayList<>();
    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors = new ArrayList<>();

    public Movie(String title, String description, String country, LocalDate release, int length) {
        this.title = title;
        this.description = description;
        this.country = country;
        this.release = release;
        this.length = length;
    }
}
