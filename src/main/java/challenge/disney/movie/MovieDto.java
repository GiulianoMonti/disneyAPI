package challenge.disney.movie;

import challenge.disney.character.CharacterDto;
import challenge.disney.character.Characters;
import challenge.disney.genre.Genre;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Data
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

