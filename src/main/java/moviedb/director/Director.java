package moviedb.director;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import moviedb.movie.Movie;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private int yearOfBirth;
    private String biography;
    @ManyToOne
    private Movie movie;

    public Director(String name, String country, int yearOfBirth, String biography) {
        this.name = name;
        this.country = country;
        this.yearOfBirth = yearOfBirth;
        this.biography = biography;
    }
}
