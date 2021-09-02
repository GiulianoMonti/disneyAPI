package challenge.disney.character;

import challenge.disney.movie.Movie;
import lombok.Data;

import java.util.List;

@Data
public class CharacterDtoForList {
    private Long id;

    private String image;
    private String name;
    private List<Movie> movie;

    public static CharacterDtoForList from(Character character) {
        CharacterDtoForList characterDtoFilter = new CharacterDtoForList();
        characterDtoFilter.setId(character.getId());
        characterDtoFilter.setName(character.getName());
        characterDtoFilter.setMovie(character.getMovies());

        return characterDtoFilter;
    }
}
