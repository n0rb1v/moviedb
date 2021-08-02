package moviedb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private int yearOfBirth;
    private String biography;
    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;

    public Actor(String name, String country, int yearOfBirth, String biography) {
        this.name = name;
        this.country = country;
        this.yearOfBirth = yearOfBirth;
        this.biography = biography;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return yearOfBirth == actor.yearOfBirth && Objects.equals(name, actor.name) && Objects.equals(country, actor.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, yearOfBirth);
    }
}
