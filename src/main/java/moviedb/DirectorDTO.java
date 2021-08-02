package moviedb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectorDTO {
    private String name;
    private String country;
    private LocalDate yearOfBirth;
    private String biography;
}
