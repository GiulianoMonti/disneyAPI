package challenge.disney.movie;

import challenge.disney.character.Character;
import challenge.disney.genre.Genre;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;
    private String title;
    private String date;
    private Integer rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="genre_id",referencedColumnName = "id")
    private Genre genre;

    @ManyToMany
    @JoinTable(
            name = "characters_in_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private List<Character> characters = new ArrayList<>();


    public void addCharacters(Character character) {
        characters.add(character);
    }

    public void assignGenre(Genre genre) {
        this.genre = genre;
    }
}