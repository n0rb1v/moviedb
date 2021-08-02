package moviedb;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCastCommand {
    @Schema(description = "name of person",example = "James Cameron")
    @IsValidName
    private String name;
    @Schema(description = "origin of born",example = "Canada")
    @NotBlank
    private String country;
    @Schema(description = "year of born",example = "1954")
    @Min(1900)
    private int yearOfBirth;
    @Schema(description = "biography",example = "biography")
    @NotNull
    private String biography;
}
