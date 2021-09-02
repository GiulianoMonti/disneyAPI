package challenge.disney.character;

import challenge.disney.movie.Movie;
import challenge.disney.movie.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    // add movie to character
    @PostMapping(value="{characterId}/movies/{movieId}/add")
    public ResponseEntity<CharacterDto> addMovieToCharacter(@PathVariable final Long movieId,
                                                        @PathVariable final Long characterId){

        Character character = characterService.addMovieToCharacter(characterId, movieId);
        return new ResponseEntity<>(CharacterDto.from(character), HttpStatus.OK);
    }

    // delete movie from character
    @DeleteMapping(value="{characterId}/movies/{movieId}/remove")
    public ResponseEntity<CharacterDto> deleteMovieFromCharacter(@PathVariable final Long movieId,
                                                            @PathVariable final Long characterId){
        Character character = characterService.removeMovieFromCharacter(movieId, characterId);
        return new ResponseEntity<>(CharacterDto.from(character), HttpStatus.OK);
    }


    @GetMapping(params = "name")
    public ResponseEntity<List<CharacterDto>> getCharacterByName(@RequestParam(value = "name", required = false) String name){
        List<Character> characters =characterService.getCharacterByName(name);

        List<CharacterDto> charactersDto = characters.stream().map(CharacterDto::from).collect(Collectors.toList());

        return new ResponseEntity<>(charactersDto,HttpStatus.OK);
    }

    @GetMapping(params = "age")
    public ResponseEntity<List<CharacterDto>> getCharacterByAge(@RequestParam(value = "age", required = false) Integer age){
        List<Character> characters =characterService.getCharacterByAge(age);

        List<CharacterDto> charactersDto = characters.stream().map(CharacterDto::from).collect(Collectors.toList());

        return new ResponseEntity<>(charactersDto,HttpStatus.OK);
    }

    @GetMapping(params = "idMovie")
    public ResponseEntity<List<CharacterDto>> getCharacterByAge(@RequestParam(value = "idMovie", required = false) String idMovie){
        List<Character> characters =characterService.getCharacterByMovie(idMovie);

        List<CharacterDto> charactersDto = characters.stream().map(CharacterDto::from).collect(Collectors.toList());

        return new ResponseEntity<>(charactersDto,HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<CharacterDtoFilter>> getCharacters() {
        List<Character> characters =characterService.getCharacters();

        List<CharacterDtoFilter> charactersDto = characters.stream().map(CharacterDtoFilter::from).collect(Collectors.toList());
        return new ResponseEntity<>(charactersDto,HttpStatus.OK);
    }

    // get list with movies
    @GetMapping("/list")
    public ResponseEntity<List<CharacterDtoForList>> getCharactersList() {
        List<Character> characters =characterService.getCharacters();

        List<CharacterDtoForList> charactersDto;
        List<CharacterDtoForList> list = new ArrayList<>();
        for (Character character : characters) {
            CharacterDtoForList from = CharacterDtoForList.from(character);
            list.add(from);
        }
        charactersDto = list;
        return new ResponseEntity<>(charactersDto,HttpStatus.OK);
    }



    @GetMapping(value="{id}")
    public ResponseEntity<CharacterDto> getCharacter(@PathVariable final Long id){
        Character character = characterService.getCharacter(id);
        return new ResponseEntity<>(CharacterDto.from(character),HttpStatus.OK);

    }



    @DeleteMapping(value = "{id}")
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



