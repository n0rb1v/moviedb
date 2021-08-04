package moviedb.actor;

import lombok.AllArgsConstructor;
import moviedb.CreateCastCommand;
import moviedb.actor.Actor;
import moviedb.actor.ActorDTO;
import moviedb.actor.ActorNotFoundException;
import moviedb.actor.ActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ActorService {
    private final ActorRepository actorRepository;
    private final ModelMapper modelMapper;

    public List<ActorDTO> listActors(Optional<String> search) {
        return actorRepository.findAll().stream()
                .filter(actor -> search.isEmpty() || actor.getName().toLowerCase().contains(search.get().toLowerCase()))
                .map(actor -> modelMapper.map(actor,ActorDTO.class))
                .collect(Collectors.toList());
    }
    public List<Actor> listActorsServ() {
        return actorRepository.findAll();
    }
    @Transactional
    public ActorDTO updateActor(long id, CreateCastCommand command) {
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new ActorNotFoundException());
        actor.setName(command.getName());
        actor.setCountry(command.getCountry());
        actor.setYearOfBirth(command.getYearOfBirth());
        actor.setBiography(command.getBiography());
        return modelMapper.map(actor,ActorDTO.class);
    }

    public ActorDTO findActorById(long id) {
        Actor actor = actorRepository.findById(id).get();
        return modelMapper.map(actor,ActorDTO.class);
    }
}
