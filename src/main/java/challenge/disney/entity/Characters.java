package challenge.disney.entity;

import challenge.disney.entity.dto.CharacterDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Characters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private String name;
    private Integer age;
    private Integer weight;
    private String story;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "characters_movies",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies = new ArrayList<>();



    public void addMovies(Movie movie) {
        movies.add(movie);
    }

    public void removeMovies(Movie movie) {
        movies.remove(movie);
    }

    public static Characters from(CharacterDto characterDto) {
        Characters character = new Characters();
        character.setImage(characterDto.getImage());
        character.setName(characterDto.getName());
        character.setAge(characterDto.getAge());
        character.setWeight(characterDto.getWeight());
        character.setStory(characterDto.getStory());
        character.setMovies(characterDto.getMovies());
        return character;
    }
}
