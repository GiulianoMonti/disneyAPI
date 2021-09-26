package challenge.disney.services.impl;

import challenge.disney.entity.Characters;
import challenge.disney.entity.Movie;
import challenge.disney.entity.dto.CharacterDtoFilter;
import challenge.disney.entity.dto.MovieDto;
import challenge.disney.entity.dto.MovieDtoFilter;
import challenge.disney.repositories.MovieRepository;
import challenge.disney.exception.MovieNotFoundException;
import challenge.disney.entity.Genre;
import challenge.disney.services.CharacterService;
import challenge.disney.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieServiceImpl implements MovieService {


    private final MovieRepository movieRepository;
    private final GenreService genreService;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository,
                            GenreService genreService) {
        this.movieRepository = movieRepository;
        this.genreService = genreService;
    }



    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getMovies() {
        return StreamSupport
                .stream(movieRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Movie getMovie(Long id) {
        return movieRepository.findById(id).orElseThrow(() ->
                new MovieNotFoundException(id));
    }


    public Movie deleteMovie(Long id) {
        Movie movie = getMovie(id);
//        characterService.deleteCharacter(id);
        movieRepository.delete(movie);
        return movie;
    }

    // edited and persisted in the database
    public Movie editMovie(Long id, Movie movie) {
        Movie movieToEdit = getMovie(id);
        movieToEdit.setRating(movie.getRating());
        movieToEdit.setCharacters(movie.getCharacters());
        movieToEdit.setGenre(movie.getGenre());
        movieToEdit.setImage(movie.getImage());
        movieToEdit.setTitle(movie.getTitle());
        return movieRepository.save(movieToEdit);
    }

    public Movie addGenreToMovie(Long genreId, Long movieId) {
        Movie movie = getMovie(movieId);
        Genre genre = genreService.getGenre(genreId);
//        if(Objects.nonNull(character.getMovies())){
//            throw new MovieIsAlreadyAssignedException(characterId, character.getMovies().get());
//        }
        movie.setGenre(genre);
        return movie;
    }

    public List<Movie> findByTitle(String name) {
        return movieRepository.findByTitle(name);
    }

    public List<Movie> findByGenre(Long genreId) {
        return movieRepository.findByGenre(genreId);
    }


    public List<Movie> sortByDate(String order) {

        return "ASC".equals(order) ? movieRepository.sortDateAsc()
                : "DESC".equals(order) ? movieRepository.sortDateDesc() : null;


    }
}