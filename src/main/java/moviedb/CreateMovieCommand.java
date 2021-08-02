package moviedb;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMovieCommand {
    @Schema(description = "title of movie",example = "Titanic")
    @NotBlank
    private String title;
    @Schema(description = "description",example = "description")
    @NotBlank
    private String description;
    @Schema(description = "origin of movie",example = "USA")
    @NotBlank
    private String country;
    private LocalDate relDate;
    @Schema(description = "length in minutes",example = "120")
    @Positive
    private int length;

}
