package moviedb;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private LocalDate yearOfBirth;
    private String biography;
    @ManyToMany
    private List<Movie> movies;

    public Actor(String name) {
        this.name = name;
    }
}
