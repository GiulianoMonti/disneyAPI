package challenge.disney.character;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc(addFilters = false)
class CharacterControllerTest {


    @Autowired
    CharacterController controller;
    @MockBean
    CharacterRepository characterRepository;
    @MockBean
    CharacterService characterService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getByName() throws Exception {
        List<Character> characters = new ArrayList<>();
        characters.add(buildCharacter());
        when(characterRepository.findByName(any())).thenReturn(characters);
        this.mockMvc.perform(get("/characters").param("name","b"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.length()",is(0)));
    }

    private Character buildCharacter() {
        Character charac = new Character();
        charac.setStory("a");
        charac.setName("b");
        charac.setWeight(11);
        charac.setStory("prueba");
        charac.setAge(111);
        charac.setMovies(null);

        return charac;
    }
}