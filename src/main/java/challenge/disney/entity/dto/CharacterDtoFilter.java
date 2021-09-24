package challenge.disney.entity.dto;

import challenge.disney.entity.Characters;
import lombok.Data;

@Data
public class CharacterDtoFilter {
    private Long id;

    private String image;
    private String name;


    public static CharacterDtoFilter from(Characters character) {
        CharacterDtoFilter characterDtoFilter = new CharacterDtoFilter();
        characterDtoFilter.setId(character.getId());
        characterDtoFilter.setName(character.getName());
        characterDtoFilter.setImage(character.getImage());

        return characterDtoFilter;
    }
}
