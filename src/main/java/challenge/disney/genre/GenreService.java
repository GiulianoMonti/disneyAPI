package challenge.disney.genre;

import challenge.disney.character.Character;
import challenge.disney.exception.CharacterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
