package moviedb.actor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import moviedb.director.DirectorDTO;
import moviedb.movie.Genre;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorMovieDTO {
    private String title;
    private String description;
    private String country;
    private LocalDate relDate;
    private int length;
    private List<Genre> genres;
    private List<Integer> rates;
    private double rate;
    private List<DirectorDTO> directors;
}
