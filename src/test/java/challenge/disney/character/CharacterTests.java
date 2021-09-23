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
import org.springframework.boot.test.mock.mockito.MockBean;
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


    @MockBean
    CharacterService characterService;

    @Mock
    CharacterRepository characterRepository;

    @Autowired
    private MockMvc mockMvc;


    Characters first = new Characters(1L, "url1", "takeshi", 35, 75, "cyberpunk", new ArrayList<>());
    Characters second = new Characters(2L, "url2", "motoko", 30, 44, "biopunk", new ArrayList<>());
    List<Characters> listaPj = Arrays.asList(first, second);

    @Test
    void testGetCharacters() throws Exception {

        when(characterService.getCharacters()).thenReturn(listaPj);

        mockMvc.perform(get("/characters/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void getCharactersByName() throws Exception {

        when(characterService.getCharacterByName("takeshi")).thenReturn(Collections.singletonList(first));

        mockMvc.perform(get("/characters?name=takeshi"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("takeshi"));

    }

}