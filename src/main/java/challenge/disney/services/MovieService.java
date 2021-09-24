package challenge.disney.services;

import challenge.disney.entity.Movie;
import challenge.disney.entity.dto.MovieDto;
import challenge.disney.entity.dto.MovieDtoFilter;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<MovieDtoFilter> getMovies();

    Movie getMovieById(Long id);

    public List<MovieDto> getMoviesList() ;

//    List<Movie> getAllAttributesOfMoviesOrSeries();

    Movie addMovie(Movie movie);

    Movie deleteMovie(Long id);

    Movie editMovie(Long id, Movie Movie);
}
