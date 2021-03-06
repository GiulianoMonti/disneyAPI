package challenge.disney.services.impl;

import challenge.disney.exception.CharacterNotFoundException;
import challenge.disney.entity.Genre;
import challenge.disney.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GenreService {
    GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

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
