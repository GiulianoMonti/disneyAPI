package challenge.disney.movie;

import challenge.disney.character.Character;
import org.springframework.data.domain.Sort;
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

//    @Query ("SELECT m FROM Movie m ORDER BY createDate ASC ")
//    List<Movie> orderByCreateDateAsc();

//    public List<Movie> findByGenre(Integer age);

//    @Query("select distinct t from Character t join t.movies u where u.id = :id")
//    public List<Movie> findByMovies(Long id);
}
