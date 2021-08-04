package moviedb.movie;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class MovieNotFoundException extends AbstractThrowableProblem {
    public MovieNotFoundException() {
        super(URI.create("movie/not-found"),
                "Not found",
                Status.NOT_FOUND,
                "Movie not found");
    }
}
