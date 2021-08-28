package challenge.disney.movie;

import challenge.disney.character.Character;
import challenge.disney.character.CharacterRepository;
import challenge.disney.genre.Genre;
import challenge.disney.genre.GenreRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    GenreRepository genreRepository;

    @GetMapping
    List<Movie> getMovie() {
        return movieRepository.findAll();
    }

    @PostMapping
    Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PutMapping("/{movieId}/characters/{characterId}")
    Movie addCharactersToMovies(
            @PathVariable Long movieId,
            @PathVariable Long characterId
    ) {
        Movie movie = movieRepository.findById(movieId).get();
        Character character = characterRepository.findById(characterId).get();
        movie.addCharacters(character);
        return movieRepository.save(movie);
    }

    @PutMapping("/{movieId}/genres/{genreId}")
    Movie assignMovieToGenre(
            @PathVariable Long movieId,
            @PathVariable Long genreId
    ) {
        Movie movie = movieRepository.findById(movieId).get();
        Genre genre  = genreRepository.findById(genreId).get();
        movie.assignGenre(genre);
        return movieRepository.save(movie);
    }
}
