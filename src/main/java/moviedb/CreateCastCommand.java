package moviedb;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCastCommand {
    @Schema(description = "name of person",example = "James Cameron")
    private String name;
    @Schema(description = "origin of born",example = "Canada")
    private String country;
    @Schema(description = "year of born",example = "1954")
    private int yearOfBirth;
    @Schema(description = "biography",example = "biography")
    private String biography;
}
