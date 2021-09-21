package challenge.disney.movie;

import challenge.disney.genre.Genre;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;

@Data
public class MovieDtoFilter {

    private Long id;
    private String image;
    private String title;

    private LocalDate date;


//    private CharacterDto
//            characters;


    public static MovieDtoFilter from(Movie movie) {
        MovieDtoFilter movieDto = new MovieDtoFilter();
        movieDto.setId(movie.getId());
        movieDto.setImage(movie.getImage());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDate(movie.getDate());

//        List<CharacterDto> list = new ArrayList<>();
//        for (Character character : movie.getCharacters()) {
//            CharacterDto from = CharacterDto.from(character);
//            list.add(from);
//        }
//        movieDto.setCharactersDto(list);
        return movieDto;
    }
}

