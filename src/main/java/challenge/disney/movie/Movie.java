package challenge.disney.movie;

import challenge.disney.character.Character;
import challenge.disney.genre.Genre;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private String title;

    private LocalDate date;
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "characters_movies",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id"))
    private List<Character> characters= new ArrayList<>();


    public static Movie from(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setImage(movieDto.getImage());
        movie.setTitle(movieDto.getTitle());
        movie.setDate(movieDto.getDate());
        movie.setRating(movieDto.getRating());
        movie.setGenre(movieDto.getGenre());
        movie.setCharacters(movieDto.getCharacter());
        return movie;
    }
}