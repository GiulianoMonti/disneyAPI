package challenge.disney.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CharacterControllerTest {

    @InjectMocks
    CharacterController characterController;


    @Mock
    CharacterService characterService;


    CharacterDto characterDto;
    Character character;


    final String CHARACTER_NAME = "takeshi";
    List<Character> characters = new ArrayList<>();

    @BeforeEach
    void setUp()throws Exception{

        MockitoAnnotations.initMocks(this);
        character = new Character();
        character.setImage("Url1");
        character.setName("takeshi");
        character.setAge(33);
        character.setWeight(77);
        character.setStory("cyberpunk");

        characters.add(character);

    }

    @Test
    void getCharacterByName() {
        characterDto = new CharacterDto();

        when(characterService.getCharacterByName(anyString())).thenReturn(characters);
        ResponseEntity<List<CharacterDto>> characs = characterController.getCharacterByName(CHARACTER_NAME);
        assertNotNull(characs);

        // comparando 2 cosas distintas
        //
        // invento ...

        assertEquals(characters.size(), Objects.requireNonNull(characs.getBody()).size());


        assertEquals(characters.get(0).getImage(),characs.getBody().get(0).getImage());

        assertEquals(characters.get(0).getName(),characs.getBody().get(0).getName());

    }
}