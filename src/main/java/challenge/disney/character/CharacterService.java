package challenge.disney.character;

import challenge.disney.exception.CharacterNotFoundException;
import challenge.disney.exception.MovieIsAlreadyAssignedException;
import challenge.disney.movie.Movie;
import challenge.disney.movie.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class CharacterService {

    @Autowired
    private CharacterRepository repo;
    @Autowired
    private MovieService movieService;

    public Character addCharacter(Character character){
        return  repo.save(character);
    }

    public List<Character> getCharacters(){
        return StreamSupport
                .stream(repo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }


    public Character getCharacter(Long id){
        return repo.findById(id).orElseThrow(()->
                new CharacterNotFoundException(id));
    }
    public List<Character> getCharacterByName(String name){
        return repo.findByName(name);
    }
    public List<Character> getCharacterByAge(Integer age){
        return repo.findByAge(age);
    }

    public List<Character> getCharacterByMovie(String idMovie){
        return repo.findByMovie(idMovie);
    }



    public Character deleteCharacter(Long id){
        Character character = getCharacter(id);
        repo.delete(character);
        return character;
    }

    // edited and persisted in the database
    @Transactional
    public Character editCharacter(Long id,Character character){
        Character characterToEdit = getCharacter(id);
        characterToEdit.setName(character.getName());
        return characterToEdit;
    }

    @Transactional
    public Character addMovieToCharacter(Long characterId, Long movieId){
        Character character = getCharacter(characterId);
        Movie movie = movieService.getMovie(movieId);
//        if(Objects.nonNull(movie.getCharacters())){
//            throw new MovieIsAlreadyAssignedException(movieId,
//                    character.getMovie().getId());
//        }
         movie.addCharacter(character);
        character.setMovie(movie);
        return character;
    }


}

