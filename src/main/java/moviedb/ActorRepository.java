package moviedb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {

//    @Query("select a from Actor a left join fetch a.movies where a.id = :id")
//    List<Movie> listActorMovies(@Param("id") long id);
}
