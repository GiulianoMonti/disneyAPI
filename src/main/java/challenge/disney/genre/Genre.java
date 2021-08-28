package challenge.disney.genre;

import challenge.disney.movie.Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Genre {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String image;

    @JsonIgnore
    @OneToMany(mappedBy = "genre")
    private List<Movie> movie = new ArrayList<>();

}
