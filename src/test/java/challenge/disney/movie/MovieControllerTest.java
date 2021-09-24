package challenge.disney.movie;

import challenge.disney.controller.MovieController;
import challenge.disney.repositories.MovieRepository;
import challenge.disney.services.impl.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc(addFilters = false)
class MovieControllerTest {
    @Autowired
    MovieController controller;
    @MockBean
    MovieRepository movieRepository;
    @MockBean
    MovieServiceImpl movieService;

    @Autowired
    private MockMvc mockMvc;



    @Test
    void getMovieList() throws Exception {

        mockMvc.perform(get("/movies/list"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}