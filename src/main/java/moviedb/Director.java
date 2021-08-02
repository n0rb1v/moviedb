package moviedb;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private LocalDate yearOfBirth;
    private String biography;
    @ManyToOne
    private Movie movie;

    public Director(String name) {
        this.name = name;
    }
}
