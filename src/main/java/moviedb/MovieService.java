package moviedb;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    public MovieDTO createMovie(CreateMovieCommand command) {
        Movie movie = new Movie(command.getTitle(),
                command.getDescription(),
                command.getCountry(),
                command.getRelDate(),
                command.getLength());
        System.out.println(movie);
        movieRepository.save(movie);
        return modelMapper.map(movie,MovieDTO.class);

    }
}
