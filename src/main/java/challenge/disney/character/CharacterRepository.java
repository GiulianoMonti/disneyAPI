package challenge.disney.character;

import challenge.disney.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
//
//    public Character findById(int id);
//
//    public List<Character> findByName(String name);
//
//    public List<Character> findByAge(Integer age);
//
//   public List<Character> findByMovies(String id);
}
