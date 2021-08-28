package challenge.disney.character;

import challenge.disney.movie.Movie;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private String name;
    private Integer age;
    private Integer weight;
    private String story;

    @JsonIgnore
    @ManyToMany(mappedBy = "characters")
    private List<Movie> movies = new ArrayList<>();
    
}
