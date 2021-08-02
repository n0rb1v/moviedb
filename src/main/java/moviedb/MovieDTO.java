package moviedb;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private String title;
    private String description;
    private String country;
    private LocalDate release;
    private int length;
    @ElementCollection
    private List<Genre> genres;
    @ElementCollection
    private List<Integer> rating;
    @OneToMany(mappedBy = "movie")
    private List<DirectorDTO> directors = new ArrayList<>();
    @ManyToMany(mappedBy = "movies")
    private List<ActorDTO> actors = new ArrayList<>();
}
