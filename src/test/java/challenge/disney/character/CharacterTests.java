//package challenge.disney.character;
//
//import challenge.disney.controller.CharacterController;
//import challenge.disney.entity.Characters;
//import challenge.disney.entity.dto.CharacterDtoFilter;
//import challenge.disney.repositories.CharacterRepository;
//import challenge.disney.services.impl.CharacterServiceImpl;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.*;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.Matchers.is;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@WebAppConfiguration
//@ActiveProfiles(value = "test")
//@AutoConfigureMockMvc(addFilters = false)
//class CharacterTests {
//
//
//    @MockBean
//    CharacterServiceImpl characterService;
//
//    @Mock
//    CharacterRepository characterRepository;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @InjectMocks
//    private CharacterController characterController;
//
//
//    CharacterDtoFilter first = new CharacterDtoFilter(1L, "url1", "takeshi");
//    Characters second = new Characters(2L, "url2", "motoko", 30, 44, "biopunk", new ArrayList<>());
//    List<CharacterDtoFilter> listaPj = List.of(first);
//    List<Characters> listaPjSecond = List.of(second);
//
//    public void setUp() throws Exception {
//
//    }
//
//    @Test
//    void testTest() throws Exception {
//        when(characterService.getCharacters()).thenReturn(listaPj);
//
//        mockMvc.perform(get("/list"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)));
//    }
//
//    @Test
//    void testGetCharacters() throws Exception {
//        when(characterService.getCharacters()).thenReturn(listaPj);
//
//        mockMvc.perform(get("/characters"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)));
//    }

//    @Test
//    void getCharactersByName() throws Exception {
//
//        when(characterService.getCharacterByName("motoko")).thenReturn(Collections.singletonList(second));
//
//        mockMvc.perform(get("/characters?name=motoko"))
//
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].image", is("url2")))
//                .andExpect(jsonPath("$[0].name", is("motoko")));
//
//    }
//
//    @Test
//    void findCharacterByAge() throws Exception {
//
//        when(characterService.getCharacterByAge(30)).thenReturn(Collections.singletonList(second));
//
//        mockMvc.perform(get("/characters?age=30"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].age").value(30));
//    }

//}