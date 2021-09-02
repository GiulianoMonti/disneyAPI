package challenge.disney.character;

import challenge.disney.movie.Movie;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CharacterDtoFilter {
    private Long id;

    private String image;
    private String name;
    private Movie movie;

    public static CharacterDtoFilter from(Character character) {
        CharacterDtoFilter characterDtoFilter = new CharacterDtoFilter();
        characterDtoFilter.setId(character.getId());
        characterDtoFilter.setName(character.getName());
        characterDtoFilter.setMovie(character.getMovie());

        return characterDtoFilter;
    }
}
