package challenge.disney.genre;

import challenge.disney.character.CharacterDto;
import challenge.disney.movie.Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
public class GenreDto {

    private Long id;
    private String name;
    private String image;
    private List<Movie> movie = new ArrayList<>();


    public static GenreDto from(Genre genre){
        GenreDto genreDto = new GenreDto();
        genreDto.setId(genre.getId());
        genreDto.setName(genre.getName());
        genreDto.setImage(genre.getImage());
        return genreDto;
    }

}
