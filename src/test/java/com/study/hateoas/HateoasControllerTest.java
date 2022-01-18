package com.study.hateoas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HateoasController.class)
class HateoasControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void test() throws Exception {
        mockMvc.perform(get("/hateoas"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._links.self").exists());
    }
}