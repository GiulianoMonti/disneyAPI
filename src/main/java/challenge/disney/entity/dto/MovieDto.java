package challenge.disney.entity.dto;

import challenge.disney.entity.Characters;
import challenge.disney.entity.Genre;
import challenge.disney.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private Long id;
    private String image;
    private String title;
    private LocalDate date;
    private Integer rating;
    private Genre genre;
    private List<Characters> character=new ArrayList<>();


    public static MovieDto from(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setImage(movie.getImage());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDate(movie.getDate());
        movieDto.setRating(movie.getRating());
        movieDto.setGenre(movie.getGenre());
        movieDto.setCharacter(movie.getCharacters());
//        List<CharacterDto> list = new ArrayList<>();
//        for (Character character : movie.getCharacters()) {
//            CharacterDto from = CharacterDto.from(character);
//            list.add(from);
//        }
//        movieDto.setCharactersDto(list);
        return movieDto;
    }
}

