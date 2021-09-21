package challenge.disney.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc(addFilters = false)
class CharacterTests {


    @InjectMocks
    CharacterService characterService;

    @Mock
    CharacterRepository characterRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    CharacterDto characterDto;



    @Test
    void testGetCharacters() throws Exception {
//        Character first = new Character(1L, "url1", "takeshi", 35, 75, "cyberpunk", new ArrayList<>());
//        Character second = new Character(2L, "url2", "motoko", 30, 44, "biopunk", new ArrayList<>());
//        List<Character> listaPj = Arrays.asList(first, second);
//
//        when(characterRepository.findByName(anyString())).thenReturn(listaPj);
//
//        List<Character> character = characterService.getCharacterByName("foofoofofoo");
//
//        assertNotNull(character);
//        assertEquals(character,listaPj);

        mockMvc.perform(get("/characters/list"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}