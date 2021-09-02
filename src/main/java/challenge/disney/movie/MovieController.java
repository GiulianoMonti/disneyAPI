package challenge.disney.movie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieController {

    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieDto> addMovie(@RequestBody final MovieDto movieDto) {
        Movie movie = movieService.addMovie(Movie.from(movieDto));
        return new ResponseEntity<>(MovieDto.from(movie), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getMovies() {
        List<Movie> movies = movieService.getMovies();
        List<MovieDto> moviesDto = movies.stream().map(MovieDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(moviesDto,HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable final Long id){
        Movie movie = movieService.getMovie(id);
        return new ResponseEntity<>(MovieDto.from(movie),HttpStatus.OK);

    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<MovieDto> deleteMovie(@PathVariable final Long id){
        Movie movie = movieService.deleteMovie(id);
        return new ResponseEntity<>(MovieDto.from(movie),HttpStatus.OK);

    }
    @PutMapping(value = "{id}")
    public ResponseEntity<MovieDto> editMovie(@PathVariable final Long id,
                                              @RequestBody final MovieDto movieDto){
        Movie movie = movieService.editMovie(id, Movie.from(movieDto));
        return new ResponseEntity<>(MovieDto.from(movie),HttpStatus.OK);

    }

//    @PostMapping(value="{movieId}/character/{characterId}/add")
//    public ResponseEntity<MovieDto> addMovieToCharacter(@PathVariable final Long movieId,
//                                                        @PathVariable final Long characterId){
//        Movie movie = movieService.addMovieToCharacter(movieId,characterId);
//
//        return new ResponseEntity<>(MovieDto.from(movie),HttpStatus.OK);
//    }
//
//    @DeleteMapping(value="{movieId}/character/{characterId}/remove")
//    public ResponseEntity<MovieDto> removeMovieFromCharacter(@PathVariable final Long movieId,
//                                                        @PathVariable final Long characterId){
//        Movie movie = movieService.removeMovieFromCharacter(movieId,characterId);
//
//        return new ResponseEntity<>(MovieDto.from(movie),HttpStatus.OK);
//    }


}


//    @PutMapping("/{movieId}/characters/{characterId}")
//    Movie addCharactersToMovies(
//            @PathVariable Long movieId,
//            @PathVariable Long characterId
//    ) {
//        Movie movie = movieRepository.findById(movieId).get();
//        Character character = characterRepository.findById(characterId).get();
//        movie.addCharacters(character);
//        return movieRepository.save(movie);
//    }

//    @PutMapping("/{movieId}/genres/{genreId}")
//    Movie assignMovieToGenre(
//            @PathVariable Long movieId,
//            @PathVariable Long genreId
//    ) {
//        Movie movie = movieRepository.findById(movieId).get();
//        Genre genre  = genreRepository.findById(genreId).get();
//        movie.assignGenre(genre);
//        return movieRepository.save(movie);
//    }

