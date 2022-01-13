package com.study.mvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MvcController.class)
public class MvcControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void test() throws Exception {
        String user = "{\"name\":\"me\", \"password\":\"123\"}";

        mockMvc.perform(post("/user/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(user))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is(equalTo("me"))))
            .andExpect(jsonPath("$.name", is("me")))
            .andExpect(jsonPath("$.password", is(equalTo(123))));
    }

    @Test
    void test_XML() throws Exception {
        String user = "{\"name\":\"me\", \"password\":\"123\"}";

        mockMvc.perform(post("/user/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_XML)
                .content(user))
                .andExpect(status().isOk())
                .andExpect(xpath("/User/name").string("me"))
                .andExpect(xpath("/User/password").string("123"));
    }
}
