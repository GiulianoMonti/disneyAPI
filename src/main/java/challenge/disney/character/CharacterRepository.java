package challenge.disney.character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {


    public List<Character> findByName(String name);

    public List<Character> findByAge(Integer age);

    @Query("select distinct t from Character t join t.movies u where u.id = :id")
    public List<Character> findByMovies(Long id);
}
