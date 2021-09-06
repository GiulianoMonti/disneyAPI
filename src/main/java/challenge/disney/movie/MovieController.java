package challenge.disney.movie;


import challenge.disney.character.Character;
import challenge.disney.character.CharacterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<MovieDtoFilter>> getMovies() {
        List<Movie> movies = movieService.getMovies();
        List<MovieDtoFilter> moviesDtoFilter = movies.stream().map(MovieDtoFilter::from).collect(Collectors.toList());
        return new ResponseEntity<>(moviesDtoFilter, HttpStatus.OK);
    }

    // list
    @GetMapping("/list")
    public ResponseEntity<List<MovieDto>> getMovieList() {
        List<Movie> movies = movieService.getMovies();

        List<MovieDto> movieDto;
        List<MovieDto> list = new ArrayList<>();
        for (Movie movie : movies) {
            MovieDto from = MovieDto.from(movie);
            list.add(from);
        }
        movieDto = list;
        return new ResponseEntity<>(movieDto, HttpStatus.OK);

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable final Long id) {
        Movie movie = movieService.getMovie(id);
        return new ResponseEntity<>(MovieDto.from(movie), HttpStatus.OK);

    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<MovieDto> deleteMovie(@PathVariable final Long id) {
        Movie movie = movieService.deleteMovie(id);
        return new ResponseEntity<>(MovieDto.from(movie), HttpStatus.OK);

    }

    @PutMapping(value = "{id}")
    public ResponseEntity<MovieDto> editMovie(@PathVariable final Long id,
                                              @RequestBody final MovieDto movieDto) {
        Movie movie = movieService.editMovie(id, Movie.from(movieDto));
        return new ResponseEntity<>(MovieDto.from(movie), HttpStatus.OK);

    }

    @PostMapping(value = "{movieId}/genre/{genreId}/add")
    public ResponseEntity<MovieDto> addGenreToMovie(@PathVariable final Long movieId,
                                                    @PathVariable final Long genreId) {
        Movie movie = movieService.addGenreToMovie(movieId, genreId);

        return new ResponseEntity<>(MovieDto.from(movie), HttpStatus.OK);
    }


}

