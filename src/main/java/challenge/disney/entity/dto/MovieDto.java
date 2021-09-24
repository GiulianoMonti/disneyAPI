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



}

