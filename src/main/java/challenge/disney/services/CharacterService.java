package challenge.disney.services;

import challenge.disney.entity.Characters;
import challenge.disney.entity.dto.CharacterDto;
import challenge.disney.entity.dto.CharacterDtoFilter;

import java.util.List;

public interface CharacterService {

     Characters addCharacter(Characters character);


    public Characters getCharacter(Long id);

    public List<Characters> getCharacters();




    public Characters deleteCharacter(Long id);

    public Characters editCharacter(Long id, Characters character);

    public Long getCharacterId(Long id);
}

