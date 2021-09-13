package challenge.disney.genre;

import challenge.disney.character.Character;
import challenge.disney.character.CharacterDto;
import challenge.disney.character.CharacterDtoFilter;
import challenge.disney.character.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/genres")
public class GenreController {
    private final GenreRepository genreRepository;

    private final GenreService genreService;
    @Autowired
    public GenreController(GenreService genreService,GenreRepository genreRepository) {
        this.genreService = genreService;
        this.genreRepository = genreRepository;
    }

    @PostMapping
    public ResponseEntity<GenreDto> addGenre(@RequestBody final GenreDto genreDto) {
        Genre genre = genreService.addGenre(Genre.from(genreDto));
        return new ResponseEntity<>(GenreDto.from(genre), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<GenreDto>> getGenres() {
        List<Genre> genres =genreService.getGenres();

        List<GenreDto> genresDto = genres.stream().map(GenreDto::from).collect(Collectors.toList());
        if(genresDto.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(genresDto,HttpStatus.OK);
    }

}
