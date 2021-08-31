package challenge.disney.movie;

import challenge.disney.character.Character;
import challenge.disney.character.CharacterService;
import challenge.disney.exception.MovieIsAlreadyAssignedException;
import challenge.disney.exception.MovieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieService {

    private MovieRepository movieRepository;
    private CharacterService characterService;

    @Autowired
    public MovieService(MovieRepository movieRepository, CharacterService characterService) {
        this.movieRepository = movieRepository;
        this.characterService = characterService;
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getMovies() {
        return StreamSupport
                .stream(movieRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Movie getMovie(Long id){
        return movieRepository.findById(id).orElseThrow(() ->
                new MovieNotFoundException(id));
    }
    public Movie deleteMovie(Long id){
        Movie movie = getMovie(id);
        movieRepository.delete(movie);
        return movie;
    }

    // edited and persisted in the database
    @Transactional
    public Movie editMovie(Long id, Movie movie){
        Movie movieToEdit = getMovie(id);
        movieToEdit.setTitle(movie.getTitle());
        return movieToEdit;
    }

    @Transactional
    public Movie addMovieToCharacter(Long movieId, Long characterId){
        Movie movie = getMovie(movieId);
        Character character = characterService.getCharacter(characterId);
//        if(Objects.nonNull(character.getMovies())){
//            throw new MovieIsAlreadyAssignedException(characterId, character.getMovies().get());
//        }
        movie.addCharacter(character);
        return movie;
    }
    @Transactional
    public Movie removeMovieFromCharacter(Long movieId, Long characterId){
        Movie movie = getMovie(movieId);
        Character character = characterService.getCharacter(characterId);
        movie.removeCharacter(character);
        return movie;
    }


}
