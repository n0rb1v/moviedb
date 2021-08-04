package moviedb.actor;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class ActorNotFoundException extends AbstractThrowableProblem {
    public ActorNotFoundException() {
        super(URI.create("actor/not-found"),
                "Not found",
                Status.NOT_FOUND,
                "Actor not found");
    }
}
