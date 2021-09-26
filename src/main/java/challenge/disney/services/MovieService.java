package challenge.disney.services;

import challenge.disney.entity.Movie;
import challenge.disney.entity.dto.MovieDto;
import challenge.disney.entity.dto.MovieDtoFilter;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> getMovies();

    Movie getMovie(Long id);


//    List<Movie> getAllAttributesOfMoviesOrSeries();

    Movie addMovie(Movie movie);

    Movie deleteMovie(Long id);

    Movie editMovie(Long id, Movie Movie);
}
