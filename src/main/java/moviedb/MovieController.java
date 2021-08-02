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
    @PostMapping("/{id}/addrate")
    @Operation(summary = "add rating to movie")
    //@ApiResponse(responseCode = "201", description = "book created")
    public MovieDTO addRate(@PathVariable("id") long id, @Valid @RequestBody MovieRateCommand command) {
        return movieService.addRate(command, id);
    }
    @PostMapping("/{id}/addgenre")
    @Operation(summary = "add genre to movie")
    //@ApiResponse(responseCode = "201", description = "book created")
    public MovieDTO addGenre(@PathVariable("id") long id, @Valid @RequestBody MovieGenreCommand command) {
        return movieService.addGenre(command, id);
    }
    @PostMapping("/{id}/adddirector")
    @Operation(summary = "add director to movie")
    //@ApiResponse(responseCode = "201", description = "book created")
    public MovieDTO addDirector(@PathVariable("id") long id, @Valid @RequestBody CreateCastCommand command) {
        return movieService.addDirector(command, id);
    }
    @PostMapping("/{id}/addactor")
    @Operation(summary = "add actor to movie")
    //@ApiResponse(responseCode = "201", description = "book created")
    public MovieDTO addActor(@PathVariable("id") long id, @Valid @RequestBody CreateCastCommand command) {
        return movieService.addActor(command, id);
    }
}
