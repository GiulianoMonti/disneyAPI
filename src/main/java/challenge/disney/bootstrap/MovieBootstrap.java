//package challenge.disney.bootstrap;
//
//
//import challenge.disney.character.Character;
//import challenge.disney.repositories.CharacterRepository;
//import challenge.disney.entity.Genre;
//import challenge.disney.repositories.GenreRepository;
//import challenge.disney.entity.Movie;
//import challenge.disney.repositories.MovieRepository;
//
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//
//
//
//@Component
//public class MovieBootstrap implements ApplicationListener<ContextRefreshedEvent> {
//
//    private final CharacterRepository characterRepository;
//    private final MovieRepository movieRepository;
//    private final GenreRepository genreRepository;
//
//    public MovieBootstrap(CharacterRepository characterRepository, MovieRepository movieRepository, GenreRepository genreRepository) {
//        this.characterRepository = characterRepository;
//        this.movieRepository = movieRepository;
//        this.genreRepository = genreRepository;
//    }
//
//    // testeando cosas
//
//    private List<Movie> getMovies() {
//
//        List<Movie> movies = new ArrayList<>(2);
//        List<Character>characters = new ArrayList<>();
//
//
//
//        Character characterOne = new Character(
//                "url1","takeshikovacs",35,75,"cyberpunk story",null);
//
//
//        Genre genreOne = new Genre("sci-fi","url1",null);
//        Movie movieOne = new Movie();
//
//
//        movieOne.setTitle("bladerunner");
//        movieOne.setImage("url1");
//        movieOne.setRating(10);
//        movieOne.setDate(LocalDate.parse("1995-12-02"));
//
//        movies.add(movieOne);
//
//        return movies;
//    }
//
//    private List<Character> getCharacters() {
//        List<Character>characters = new ArrayList<>();
//
//        Character characterOne = new Character();
//characterOne.setName("takeshi");
//            characters.add(characterOne);
//            return characters;
//    }
//
//
//        @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        characterRepository.saveAll(getCharacters());
//    }
//}