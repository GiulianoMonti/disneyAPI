package challenge.disney.services.impl;

import challenge.disney.entity.dto.CharacterDto;
import challenge.disney.entity.dto.CharacterDtoFilter;
import challenge.disney.entity.dto.MovieDto;
import challenge.disney.entity.dto.MovieDtoFilter;
import challenge.disney.repositories.CharacterRepository;
import challenge.disney.entity.Characters;
import challenge.disney.exception.CharacterNotFoundException;
import challenge.disney.entity.Movie;
import challenge.disney.repositories.MovieRepository;
import challenge.disney.services.CharacterService;
import challenge.disney.services.MovieService;
import challenge.disney.services.impl.MovieServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired

    private CharacterRepository repo;
    @Autowired

    private MovieService movieService;



    public Characters addCharacter(Characters character){

        repo.save(character);
        return  character;
    }

    public List<Characters> getCharacters(){
        return repo.findAll();
    }


    public Characters getCharacter(Long id){
        return repo.findById(id).orElseThrow(()->
                new CharacterNotFoundException(id));
    }
    public List<Characters> getCharacterByName(String name){
        return repo.findByName(name);
    }
    public List<Characters> getCharacterByAge(Integer age){
        return repo.findByAge(age);
    }

    public List<Characters> getCharacterByMovie(Long idMovie){
        return repo.findByMovies(idMovie);
    }



    public Characters deleteCharacter(Long id){
        Characters character = getCharacter(id);
        repo.delete(character);
        return character;
    }

    // edited and persisted in the database
    @Transactional
    public Characters editCharacter(Long id,Characters character){
        Characters characterToEdit = getCharacter(id);
        characterToEdit.setName(character.getName());
        characterToEdit.setMovies(character.getMovies());
        characterToEdit.setStory(character.getStory());
        characterToEdit.setImage(character.getImage());
        characterToEdit.setAge(character.getAge());
        characterToEdit.setWeight(character.getWeight());
        return characterToEdit;


    }

    @Transactional
    public Characters addMovieToCharacter(Long characterId, Long movieId){
        Characters character = getCharacter(characterId);
        Movie movie = movieService.getMovie(movieId);
//        if(Objects.nonNull(movie.getCharacters())){
//            throw new MovieIsAlreadyAssignedException(movieId,
//                    movie.getCharacters().getId());
//        }
        character.addMovies(movie);
        movie.setCharacters(Collections.singletonList(character));
        return character;
    }

    @Transactional
    public Characters removeMovieFromCharacter(Long movieId, Long characterId){
        Characters character = getCharacter(characterId);
        Movie movie = movieService.getMovie(movieId);
        character.removeMovies(movie);
        return character;
    }

    public Long getCharacterId(Long id){
        Characters character = getCharacter(id);
        return  character.getId();

    }


}
