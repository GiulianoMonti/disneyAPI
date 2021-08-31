package challenge.disney.genre;

import challenge.disney.movie.Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Data
public class Genre {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String image;

    @JsonIgnore
    @OneToMany(mappedBy = "genre")
    private Set<Movie> movie = new HashSet<>();

}
