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
    List<Genre> getTeachers() {
        return genreRepository.findAll();
    }

    @PostMapping
    Genre createTeacher(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }
}
