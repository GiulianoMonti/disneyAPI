package challenge.disney.controller;


import challenge.disney.entity.Characters;
import challenge.disney.entity.Genre;
import challenge.disney.entity.Movie;
import challenge.disney.entity.dto.CharacterDto;
import challenge.disney.entity.dto.MovieDto;
import challenge.disney.entity.dto.MovieDtoFilter;
import challenge.disney.services.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.NotContextException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieServiceImpl movieService;

    @Autowired
    public MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody final Movie movie) throws NotContextException {


        Movie movies = movieService.addMovie(movie);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MovieDtoFilter>> getMovies() {

        return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<MovieDto>> getMovieList() {
        List<MovieDto> movies = movieService.getMoviesList();


        return new ResponseEntity<>(movies, HttpStatus.OK);

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable final Long id) {
        Movie movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);

    }

    @GetMapping(params = "name")
    public ResponseEntity<List<MovieDto>> getMovieByName(@RequestParam(value = "name", required = false) String name) {
        List<MovieDto> movies = movieService.findByTitle(name);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(params = "genre")
    public ResponseEntity<List<MovieDto>> getMovieByGenre(@RequestParam(value = "genre", required = false) Long genreId) {

        List<MovieDto> movies = movieService.findByGenre(genreId);

        return movies.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(params = "order")
    public ResponseEntity<List<Movie>> getMovieByDate(@RequestParam(value = "order", required = false) String order) {

        List<Movie> movies = movieService.sortByDate(order);

        return movies.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(movies, HttpStatus.OK);

    }


    @DeleteMapping(value = "{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable final Long id) {
        Movie movie = movieService.deleteMovie(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);

    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Movie> editMovie(@PathVariable final Long id,
                                           @RequestBody final Movie movies) {
        Movie movie = movieService.editMovie(id, movies);
        return new ResponseEntity<>(movie, HttpStatus.OK);

    }

//    @PostMapping(value = "{movieId}/genre/{genreId}/add")
//    public ResponseEntity<MovieDto> addGenreToMovie(@PathVariable final Long movieId,
//                                                    @PathVariable final Long genreId) {
//        Movie movie = movieService.addGenreToMovie(movieId, genreId);
//
//        return new ResponseEntity<>(MovieDto.from(movie), HttpStatus.OK);
//    }


}

