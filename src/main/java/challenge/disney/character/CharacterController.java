package challenge.disney.character;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public ResponseEntity<CharacterDto> addItem(@RequestBody final CharacterDto characterDto) {
        Character character = characterService.addCharacter(Character.from(characterDto));
        return new ResponseEntity<>(CharacterDto.from(character), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CharacterDtoFilter>> getCharacters() {
      List<Character> characters =characterService.getCharacters();

       List<CharacterDtoFilter> charactersDto = characters.stream().map(CharacterDtoFilter::from).collect(Collectors.toList());
       return new ResponseEntity<>(charactersDto,HttpStatus.OK);
    }

    @GetMapping(value="{id}")
    public ResponseEntity<CharacterDto> getCharacter(@PathVariable final Long id){
        Character character = characterService.getCharacter(id);
        return new ResponseEntity<>(CharacterDto.from(character),HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity<CharacterDto> deleteCharacter(@PathVariable final Long id){
        Character character = characterService.deleteCharacter(id);
        return new ResponseEntity<>(CharacterDto.from(character),HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CharacterDto> editItem(@PathVariable final Long id,
                                                 @RequestBody final CharacterDto characterDto){

        Character editedCharacter = characterService.editCharacter(id,Character.from(characterDto));
        return new ResponseEntity<>(CharacterDto.from(editedCharacter),HttpStatus.OK);

    }


}

//    @DeleteMapping(path = "delete/{id}")
//    public String delete(@PathVariable("id") Integer id){
//        try {
//            characterService.delete(id);
//            return "Character was deleted id: " + id;
//        } catch (Exception e) {
//            return "Character cannot deleted id: " + id;
//        }
//    }



