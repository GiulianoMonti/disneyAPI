package challenge.disney.entity.dto;

import challenge.disney.entity.Characters;
import challenge.disney.entity.Movie;
import lombok.Data;

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

    private List <Movie> movies = new ArrayList<>();


    public static CharacterDto from(Characters character){
        CharacterDto characterDto = new CharacterDto();
        characterDto.setId(character.getId());
        characterDto.setImage(character.getImage());
        characterDto.setName(character.getName());
        characterDto.setAge(character.getAge());
        characterDto.setWeight(character.getWeight());
        characterDto.setStory(character.getStory());
        characterDto.setMovies(character.getMovies());
        return characterDto;
    }

}
