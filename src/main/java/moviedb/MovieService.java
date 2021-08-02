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
    public MovieDTO addRate(MovieRateCommand command,long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        movie.addRating(command.getRate());
        return modelMapper.map(movie,MovieDTO.class);
    }
    @Transactional
    public MovieDTO addGenre(MovieGenreCommand command,long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        movie.addGenre(command.getGenre());
        return modelMapper.map(movie,MovieDTO.class);
    }
    @Transactional
    public MovieDTO addDirector(CreateCastCommand command, long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        movie.addDirector(new Director(command.getName(), command.getCountry(), command.getYearOfBirth(), command.getBiography()));
        return modelMapper.map(movie,MovieDTO.class);
    }
    @Transactional
    public MovieDTO addActor(CreateCastCommand command, long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        movie.addActor(new Actor(command.getName(), command.getCountry(), command.getYearOfBirth(), command.getBiography()));
        return modelMapper.map(movie,MovieDTO.class);
    }

}
