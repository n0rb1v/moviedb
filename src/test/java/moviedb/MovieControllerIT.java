package moviedb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieControllerIT {

    @Autowired
    TestRestTemplate template;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieService movieService;

    @BeforeEach
    void init() {
        movieService.deleteAll();
        template.delete("/api/movies");
    }

    @Test
    void testAddNewMovie() {
        MovieDTO result =
                template.postForObject("/api/movies",
                        new CreateMovieCommand("Titanic","description","USA",LocalDate.of(1997, 6, 30),120),
                        MovieDTO.class);

        assertEquals("Titanic", result.getTitle());
        assertEquals(1997, result.getRelDate().getYear());
        assertEquals(120, result.getLength());
    }
    @Test
    void testListMovies() {
        Movie m1 = movieRepository.save(new Movie("Titanic","description","USA",LocalDate.of(1997, 8, 2),180));
        movieService.addActor(new CreateCastCommand("Leonardo DiCaprio","USA",1974,"biography"),m1.getId());
        movieService.addDirector(new CreateCastCommand("James Cameron","Canada",1954,"biography"),m1.getId());
        movieService.addGenre(new MovieGenreCommand(Genre.ACTION), m1.getId());
        movieService.addRate(new MovieRateCommand(4), m1.getId());
        Movie m2 = movieRepository.save(new Movie("The Aviator","description","USA",LocalDate.of(2004, 8, 2),170));
        movieService.addActor(new CreateCastCommand("Leonardo DiCaprio","USA",1974,"biography"),m2.getId());

        List<MovieDTO> result = template.exchange(
                "/api/movies",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MovieDTO>>() {
                }).getBody();
        assertThat(result)
                .extracting(MovieDTO::getTitle)
                .containsExactly("Titanic", "The Aviator");
    }
    @Test
    void testUpdateMovie() {
        Movie m1 = movieRepository.save(new Movie("Titanic","description","USA",LocalDate.of(1997, 8, 2),180));
        template.put("/api/movies/"+m1.getId(),
                new CreateMovieCommand("Terminator","description","USA",LocalDate.of(1985, 6, 30),120),
                MovieDTO.class);

        List<MovieDTO> result = template.exchange(
                "/api/movies",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MovieDTO>>() {
                }).getBody();
        assertEquals("Terminator",result.get(0).getTitle());
        assertEquals(1985,result.get(0).getRelDate().getYear());
        assertEquals(120,result.get(0).getLength());

    }
    @Test
    void testAddRating() {
        Movie m1 = movieRepository.save(new Movie("Titanic","description","USA",LocalDate.of(1997, 8, 2),180));
        MovieDTO result =
                template.postForObject("/api/movies/"+m1.getId()+"/addrate",
                        new MovieRateCommand(3),
                        MovieDTO.class);

        assertEquals(3,result.getRates().get(0));
    }
    @Test
    void testAddGenre() {
        Movie m1 = movieRepository.save(new Movie("Titanic","description","USA",LocalDate.of(1997, 8, 2),180));
        MovieDTO result =
                template.postForObject("/api/movies/"+m1.getId()+"/addgenre",
                        new MovieGenreCommand(Genre.ACTION),
                        MovieDTO.class);

        assertEquals(Genre.ACTION,result.getGenres().get(0));
    }
    @Test
    void testAddDirector() {
        Movie m1 = movieRepository.save(new Movie("Titanic","description","USA",LocalDate.of(1997, 8, 2),180));
        MovieDTO result =
                template.postForObject("/api/movies/"+m1.getId()+"/adddirector",
                        new CreateCastCommand("James Cameron","Canada",1954,"biography"),
                        MovieDTO.class);

        assertEquals("James Cameron",result.getDirectors().get(0).getName());
        assertEquals("Canada",result.getDirectors().get(0).getCountry());
        assertEquals(1954,result.getDirectors().get(0).getYearOfBirth());
    }
    @Test
    void testAddActor() {
        Movie m1 = movieRepository.save(new Movie("Titanic","description","USA",LocalDate.of(1997, 8, 2),180));
        MovieDTO result =
                template.postForObject("/api/movies/"+m1.getId()+"/addactor",
                        new CreateCastCommand("Leonardo DiCaprio","USA",1974,"biography"),
                        MovieDTO.class);

        assertEquals("Leonardo DiCaprio",result.getActors().get(0).getName());
        assertEquals("USA",result.getActors().get(0).getCountry());
        assertEquals(1974,result.getActors().get(0).getYearOfBirth());
    }
    @Test
    void testDelete() {
        Movie m1 = movieRepository.save(new Movie("Titanic","description","USA",LocalDate.of(1997, 8, 2),180));
        template.delete("/api/movies/"+m1.getId()+"/delete");

        List<MovieDTO> result = template.exchange(
                "/api/movies",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MovieDTO>>() {
                }).getBody();
        assertEquals(0,result.size());
    }
    @Test
    void testDeleteAll() {
        Movie m1 = movieRepository.save(new Movie("Titanic","description","USA",LocalDate.of(1997, 8, 2),180));
        Movie m2 = movieRepository.save(new Movie("The Aviator","description","USA",LocalDate.of(2004, 8, 2),170));
        template.delete("/api/movies");

        List<MovieDTO> result = template.exchange(
                "/api/movies",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MovieDTO>>() {
                }).getBody();
        assertEquals(0,result.size());
    }
    @Test
    void notFoundMovieTest(){
        Problem result =
                template.postForObject("/api/movies/1/addrate",
                        new MovieRateCommand(3),
                        Problem.class);

        assertEquals(URI.create("movie/not-found"),result.getType());
        assertEquals(Status.NOT_FOUND, result.getStatus());
    }
    @Test
    void testCreateMovieInvalidName() {
        Problem result =
                template.postForObject("/api/movies",
                        new CreateMovieCommand("","description","USA",LocalDate.of(1997, 6, 30),120),
                        Problem.class);

        assertEquals(Status.BAD_REQUEST,result.getStatus());
        assertEquals("Constraint Violation", result.getTitle());
    }
}