package moviedb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String country;
    private LocalDate reldate;
    private int length;
    @ElementCollection
    private List<Genre> genres = new ArrayList<>();
    @ElementCollection
    private List<Integer> rates = new ArrayList<>();
    private double rate;
    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Director> directors = new ArrayList<>();
    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors = new ArrayList<>();

    public Movie(String title, String description, String country, LocalDate reldate, int length) {
        this.title = title;
        this.description = description;
        this.country = country;
        this.reldate = reldate;
        this.length = length;
    }
    public Movie addDirector(Director director) {
        directors.add(director);
        director.setMovie(this);
        return this;
    }
    public Movie addGenre(Genre genre) {
        genres.add(genre);
        return this;
    }
    public Movie addRating(int i) {
        rates.add(i);
        rate=rates.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
        return this;
    }
    public Movie addActor(Actor actor) {
        actors.add(actor);
        return this;
    }

}
