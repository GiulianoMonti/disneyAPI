package challenge.disney.character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
//
//    public Character findById(int id);
//
     public List<Character> findByName(String name);

    public List<Character> findByAge(Integer age);

   public List<Character> findByMovie(String id);
}
