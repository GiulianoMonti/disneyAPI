package challenge.disney.character;

import challenge.disney.movie.Movie;
import challenge.disney.movie.MovieDto;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
    @Autowired
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }


    @PostMapping
    public ResponseEntity<CharacterDto> addCharacter(@RequestBody final CharacterDto characterDto) {
        Character character = characterService.addCharacter(Character.from(characterDto));
        return new ResponseEntity<>(CharacterDto.from(character), HttpStatus.CREATED);
    }

    // add movie to character
    @PostMapping(value="{characterId}/movie/{movieId}/add")
    public ResponseEntity<CharacterDto> addMovieToCharacter(@PathVariable final Long movieId,
                                                        @PathVariable final Long characterId){

        Character character = characterService.addMovieToCharacter(characterId, movieId);
        return new ResponseEntity<>(CharacterDto.from(character), HttpStatus.OK);
    }

    // delete movie from character
    @DeleteMapping(value="{characterId}/movie/{movieId}/remove")
    public ResponseEntity<CharacterDto> deleteMovieFromCharacter(@PathVariable final Long movieId,
                                                            @PathVariable final Long characterId){
        Character character = characterService.removeMovieFromCharacter(movieId, characterId);
        return new ResponseEntity<>(CharacterDto.from(character), HttpStatus.OK);
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<CharacterDto> deleteCharacter(@PathVariable final Long id){

        // hmmmmm..... invention
//        for(Movie movies: character.getMovies()){
//            characterService.deleteCharacter(movies.getId());
//        }
        Character character = characterService.deleteCharacter(id);



        return new ResponseEntity<>(CharacterDto.from(character),HttpStatus.OK);
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

    @GetMapping(params = "movie")
    public ResponseEntity<List<CharacterDto>> getByName(@RequestParam(value = "movie") Long idMovie){
        List<Character> characters =characterService.getCharacterByMovie(idMovie);

        List<CharacterDto> charactersDto = characters.stream().map(CharacterDto::from).collect(Collectors.toList());

        return new ResponseEntity<>(charactersDto,HttpStatus.OK);
    }



    @GetMapping
    public ResponseEntity<List<CharacterDtoFilter>> getCharacters() {
        List<Character> characters =characterService.getCharacters();

        List<CharacterDtoFilter> charactersDto = characters.stream().map(CharacterDtoFilter::from).collect(Collectors.toList());
        if(charactersDto.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(charactersDto,HttpStatus.OK);
    }

    // get list with movies
    @GetMapping("/list")
    public ResponseEntity<List<CharacterDto>> getCharactersList() {
        List<Character> characters =characterService.getCharacters();

        List<CharacterDto> charactersDto;
        List<CharacterDto> list = new ArrayList<>();
        for (Character character : characters) {
            CharacterDto from = CharacterDto.from(character);
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

    @PutMapping(value = "{id}")
    public ResponseEntity<CharacterDto> editCharacter(@PathVariable final Long id,
                                                 @RequestBody final CharacterDto characterDto){

        Character editedCharacter = characterService.editCharacter(id,Character.from(characterDto));
        return new ResponseEntity<>(CharacterDto.from(editedCharacter),HttpStatus.OK);

    }


}



