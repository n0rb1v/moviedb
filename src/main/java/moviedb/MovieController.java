package moviedb;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {
    private MovieService movieService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "creates a movie")
    @ApiResponse(responseCode = "201",description = "movie created")
    public MovieDTO createMovie(@Valid @RequestBody CreateMovieCommand command) {
        return movieService.createMovie(command);
    }
    @PostMapping("/{id}/rate")
    @Operation(summary = "add rating to movie")
    //@ApiResponse(responseCode = "201", description = "book created")
    public MovieDTO addRate(@PathVariable("id") long id, @Valid @RequestBody MovieRateCommand command) {
        return movieService.addRate(command.getRate(), id);
    }
}
