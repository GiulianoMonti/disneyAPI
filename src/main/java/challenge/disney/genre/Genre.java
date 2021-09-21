package challenge.disney.genre;

import challenge.disney.character.CharacterDto;
import challenge.disney.movie.Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String image;

    @JsonIgnore
    @OneToMany(mappedBy = "genre",cascade=CascadeType.MERGE)
    private List<Movie> movies = new ArrayList<>();

    public Genre(String name, String image, List<Movie> movies) {
        this.name = name;
        this.image = image;
        this.movies = movies;
    }

    public void addMovies(Movie movie) {
        movies.add(movie);
    }

    public void removeMovies(Movie movie) {
        movies.remove(movie);
    }

    public static Genre from(GenreDto genreDto){
        Genre genre = new Genre();
        genre.setId(genreDto.getId());
        genre.setName(genreDto.getName());
        genre.setImage(genreDto.getImage());

        return genre;
    }

}
