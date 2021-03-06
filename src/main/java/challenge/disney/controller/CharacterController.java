package challenge.disney.controller;

import challenge.disney.entity.dto.CharacterDto;
import challenge.disney.entity.dto.CharacterDtoFilter;
import challenge.disney.entity.Characters;
import challenge.disney.repositories.CharacterRepository;
import challenge.disney.services.CharacterService;
import challenge.disney.services.impl.CharacterServiceImpl;
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
    private final CharacterServiceImpl characterService;

    @Autowired
    public CharacterController(CharacterServiceImpl characterService, CharacterRepository characterRepository) {
        this.characterService = characterService;
    }


    @PostMapping
    public ResponseEntity<CharacterDto> addCharacter(@RequestBody final CharacterDto characterDto) {
        Characters character = characterService.addCharacter(Characters.from(characterDto));
        return new ResponseEntity<>(CharacterDto.from(character), HttpStatus.CREATED);
    }

    // add movie to character
    @PostMapping(value = "{characterId}/movie/{movieId}/add")
    public ResponseEntity<CharacterDto> addMovieToCharacter(@PathVariable final Long movieId,
                                                            @PathVariable final Long characterId) {

        Characters character = characterService.addMovieToCharacter(characterId, movieId);
        return new ResponseEntity<>(CharacterDto.from(character), HttpStatus.OK);
    }

    // delete movie from character
    @DeleteMapping(value = "{characterId}/movie/{movieId}/remove")
    public ResponseEntity<CharacterDto> deleteMovieFromCharacter(@PathVariable final Long movieId,
                                                                 @PathVariable final Long characterId) {
        Characters character = characterService.removeMovieFromCharacter(movieId, characterId);
        return new ResponseEntity<>(CharacterDto.from(character), HttpStatus.OK);
    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<CharacterDto> deleteCharacter(@PathVariable final Long id) {

        // hmmmmm..... invention
//        for(Movie movies: character.getMovies()){
//            characterService.deleteCharacter(movies.getId());
//        }
        Characters character = characterService.deleteCharacter(id);


        return new ResponseEntity<>(CharacterDto.from(character), HttpStatus.OK);
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<CharacterDto>> getCharacterByName(@RequestParam(value = "name", required = false) String name) {
        List<Characters> characters = characterService.getCharacterByName(name);

        List<CharacterDto> charactersDto = characters.stream().map(CharacterDto::from).collect(Collectors.toList());

        return new ResponseEntity<>(charactersDto, HttpStatus.OK);
    }

    @GetMapping(params = "age")
    public ResponseEntity<List<CharacterDto>> getCharacterByAge(@RequestParam(value = "age", required = false) Integer age) {
        List<Characters> characters = characterService.getCharacterByAge(age);

        List<CharacterDto> charactersDto = characters.stream().map(CharacterDto::from).collect(Collectors.toList());

        return new ResponseEntity<>(charactersDto, HttpStatus.OK);
    }

    @GetMapping(params = "movie")
    public ResponseEntity<List<CharacterDto>> getByName(@RequestParam(value = "movie") Long idMovie) {
        List<Characters> characters = characterService.getCharacterByMovie(idMovie);

        List<CharacterDto> charactersDto = characters.stream().map(CharacterDto::from).collect(Collectors.toList());

        return new ResponseEntity<>(charactersDto, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<CharacterDtoFilter>> getCharacters() {
        List<Characters> characters = characterService.getCharacters();

        List<CharacterDtoFilter> charactersDtoFilter = characters.stream().map(CharacterDtoFilter::from).collect(Collectors.toList());
        if (charactersDtoFilter.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(charactersDtoFilter, HttpStatus.OK);
    }

    // get list with movies
    @GetMapping("/list")
    public ResponseEntity<List<CharacterDto>> getCharactersList() {
        List<Characters> characters = characterService.getCharacters();

        List<CharacterDto> charactersDto;
        List<CharacterDto> list = new ArrayList<>();
        for (Characters character : characters) {
            CharacterDto from = CharacterDto.from(character);
            list.add(from);
        }
        charactersDto = list;
        return new ResponseEntity<>(charactersDto, HttpStatus.OK);
    }


    @GetMapping(value = "{id}")
    public ResponseEntity<CharacterDto> getCharacter(@PathVariable final Long id) {
        Characters character = characterService.getCharacter(id);
        return new ResponseEntity<>(CharacterDto.from(character), HttpStatus.OK);

    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CharacterDto> editCharacter(@PathVariable final Long id,
                                                      @RequestBody final CharacterDto characterDto) {

        Characters editedCharacter = characterService.editCharacter(id, Characters.from(characterDto));
        return new ResponseEntity<>(CharacterDto.from(editedCharacter), HttpStatus.OK);

    }


}

