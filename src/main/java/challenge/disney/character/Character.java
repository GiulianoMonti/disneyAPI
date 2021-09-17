package challenge.disney.character;

import challenge.disney.movie.Movie;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.*;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private String name;
    private Integer age;
    private Integer weight;
    private String story;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "characters_movies",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies = new ArrayList<>();

    public Character(String image, String name, Integer age, Integer weight, String story, List<Movie> movies) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.story = story;
        this.movies = movies;
    }


    public void addMovies(Movie movie) {
        movies.add(movie);
    }

    public void removeMovies(Movie movie) {
        movies.remove(movie);
    }

    public static Character from(CharacterDto characterDto) {
        Character character = new Character();
        character.setImage(characterDto.getImage());
        character.setName(characterDto.getName());
        character.setAge(characterDto.getAge());
        character.setWeight(characterDto.getWeight());
        character.setStory(characterDto.getStory());
        character.setMovies(characterDto.getMovies());
        return character;
    }
}
