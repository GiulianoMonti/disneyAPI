package challenge.disney.repositories;

import challenge.disney.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    public List<Movie> findByTitle(String name);


    @Query("select c from Movie c where c.genre.id = :genreId")
    public List<Movie> findByGenre(Long genreId);


    @Query ("select c from Movie c order by Date ASC ")
    List<Movie> sortDateAsc();

    @Query ("select c from Movie c order by Date Desc ")
    List<Movie> sortDateDesc();


}
