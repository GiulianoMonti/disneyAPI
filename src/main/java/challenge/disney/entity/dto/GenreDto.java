package challenge.disney.entity.dto;

import challenge.disney.entity.Genre;
import challenge.disney.entity.Movie;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


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
