package challenge.disney.repositories;

import challenge.disney.entity.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Characters, Long> {

    Optional<Characters> findById(Long id);
    public List<Characters> findByName(String name);

    public List<Characters> findByAge(Integer age);

    @Query("select distinct t from Characters t join t.movies u where u.id = :id")
    public List<Characters> findByMovies(Long id);
}
