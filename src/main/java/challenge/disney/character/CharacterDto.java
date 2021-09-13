package challenge.disney.character;

import challenge.disney.movie.Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class CharacterDto {
    private Long id;

    private String image;
    private String name;
    private Integer age;
    private Integer weight;
    private String story;

    private List <Movie> movie = new ArrayList<>();

    public static CharacterDto from(Character character){
        CharacterDto characterDto = new CharacterDto();
        characterDto.setId(character.getId());
        characterDto.setImage(character.getImage());
        characterDto.setName(character.getName());
        characterDto.setAge(character.getAge());
        characterDto.setWeight(character.getWeight());
        characterDto.setStory(character.getStory());
        characterDto.setMovie(character.getMovies());
        return characterDto;
    }
}
