package moviedb;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMovieCommand {
    @Schema(description = "title of movie",example = "Titanic")
    private String title;
    private String description;
    @Schema(description = "origin of movie",example = "USA")
    private String country;
    private LocalDate release;
    @Schema(description = "length in minutes",example = "120")
    private int length;
}
