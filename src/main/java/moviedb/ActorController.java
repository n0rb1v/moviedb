package moviedb;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/actors")
public class ActorController {
    private ActorService actorService;

    @GetMapping
    @Operation(summary = "list of actors")
    public List<ActorDTO> listActors(@RequestParam Optional<String> search) {
        return actorService.listActors(search);
    }
    @GetMapping("/{id}")
    @Operation(summary = "actor data")
    public ActorDTO findActorById(@PathVariable("id") long id){
        return actorService.findActorById(id);
    }
    @PutMapping("/{id}")
    @Operation(summary = "update actor data")
    public ActorDTO updateMovie(@PathVariable("id") long id, @Valid @RequestBody CreateCastCommand command){
        return actorService.updateActor(id,command);
    }

}
