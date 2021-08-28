package challenge.disney.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    GenreRepository genreRepository;

    @GetMapping
    List<Genre> getGenre() {
        return genreRepository.findAll();
    }

    @PostMapping
    Genre createGenre(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }
}
