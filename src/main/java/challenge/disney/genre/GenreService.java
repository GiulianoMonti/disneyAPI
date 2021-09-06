package challenge.disney.genre;

import challenge.disney.character.Character;
import challenge.disney.exception.CharacterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;

    public Genre addGenre(Genre genre){
        return  genreRepository.save(genre);
    }

    public Genre getGenre(Long id){
        return genreRepository.findById(id).orElseThrow(()->
                new CharacterNotFoundException(id));
    }
    public List<Genre> getGenres(){
        return StreamSupport
                .stream(genreRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
