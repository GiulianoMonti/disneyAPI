package challenge.disney.entity.dto;

import challenge.disney.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDtoFilter {

    private Long id;
    private String image;
    private String title;

    private LocalDate date;


}

