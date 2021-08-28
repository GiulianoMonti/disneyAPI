package challenge.disney.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    CharacterRepository characterRepository;

    @GetMapping
    List<Character> getCharacter() {
        return characterRepository.findAll();
    }

    @PostMapping
    Character createCharacter(@RequestBody Character character) {
        return characterRepository.save(character);
    }
}

