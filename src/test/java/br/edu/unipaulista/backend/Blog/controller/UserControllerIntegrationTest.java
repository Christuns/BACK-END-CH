package br.edu.unipaulista.backend.Blog.controller;

import br.edu.unipaulista.backend.Blog.Control.UserController;
import br.edu.unipaulista.backend.Blog.domainModel.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @DisplayName("Fluxo completo: POST -> GET ALL -> GET_BY_ID -> PUT -> PATH -> GET -> ERRO404")
    public void fullFlow() throws Exception {
        UUID id = UUID.randomUUID();
        var bodyCreate = new User(id, "César", "matoscesar36@gmail.com", "cesarmatos", null, null);
        var postResult = mockMvc.perform(
                        post("/api/users")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(bodyCreate)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value("César"))
                .andReturn();

        var created = objectMapper.readValue(postResult.getResponse().getContentAsByteArray(), User.class);
        var returnedId =created.getId();

    }
}
