package challenge.disney.movie;

import challenge.disney.character.Character;
import challenge.disney.genre.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private String title;
    private Date date;
    private Integer rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

    @ManyToMany(mappedBy = "movies")
    @JsonIgnore
//    @ManyToOne
    private List<Character> characters= new ArrayList<>();


    public static Movie from(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setImage(movieDto.getImage());
        movie.setTitle(movieDto.getTitle());
        movie.setDate(movieDto.getDate());
        movie.setRating(movieDto.getRating());
        return movie;
    }
}