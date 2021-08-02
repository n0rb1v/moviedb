package moviedb;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<MovieDTO> listAuthors(Optional<String> search) {
        return movieRepository.findAll().stream()
                .filter(movie -> search.isEmpty() || movie.getTitle().toLowerCase().contains(search.get().toLowerCase()))
                .map(author -> modelMapper.map(author,MovieDTO.class))
                .collect(Collectors.toList());
    }
    @Transactional
    public MovieDTO updateMovie(long id, CreateMovieCommand command) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        movie.setTitle(command.getTitle());
        movie.setDescription(command.getDescription());
        movie.setCountry(command.getCountry());
        movie.setReldate(command.getRelDate());
        movie.setLength(command.getLength());
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
    public void deleteMovie(long id) {
        movieRepository.deleteById(id);
    }
    public void deleteAll() {
        movieRepository.deleteAll();
    }


}
