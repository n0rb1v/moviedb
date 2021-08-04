package moviedb.actor;

import lombok.*;
import moviedb.movie.Movie;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    private String name;
    private String country;
    private int yearOfBirth;
    @EqualsAndHashCode.Exclude
    private String biography;
    @ManyToMany(mappedBy = "actors")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Movie> movies;

    public Actor(String name, String country, int yearOfBirth, String biography) {
        this.name = name;
        this.country = country;
        this.yearOfBirth = yearOfBirth;
        this.biography = biography;
    }
}
