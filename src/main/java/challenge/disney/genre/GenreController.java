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
    @Autowired
    GenreRepository genreRepository;

    @Autowired
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    public ResponseEntity<GenreDto> addItem(@RequestBody final GenreDto genreDto) {
        Genre genre = genreService.addGenre(Genre.from(genreDto));
        return new ResponseEntity<>(GenreDto.from(genre), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<GenreDto>> getCharacters() {
        List<Genre> genres =genreService.getGenres();

        List<GenreDto> genresDto = genres.stream().map(GenreDto::from).collect(Collectors.toList());
        if(genresDto.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(genresDto,HttpStatus.OK);
    }

}
