package moviedb;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public MovieDTO addRate(int rate,long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        movie.addRating(rate);
        return modelMapper.map(movie,MovieDTO.class);
    }
}
