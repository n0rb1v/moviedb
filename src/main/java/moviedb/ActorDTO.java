package moviedb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorDTO {
    private String name;
    private String country;
    private int yearOfBirth;
    private String biography;
}
