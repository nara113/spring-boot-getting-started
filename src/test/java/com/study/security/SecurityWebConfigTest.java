package com.study.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SecurityWebConfig.class)
class SecurityWebConfigTest {

    @Autowired
    MockMvc mockMvc;

    @WithMockUser
    @Test
    void test() throws Exception {
        mockMvc.perform(get("/securityHello"))
                .andExpect(status().isOk())
                .andExpect(view().name("securityHello"));
    }

    @Test
    void test_no_user() throws Exception {
        mockMvc.perform(get("/securityHello"))
                .andExpect(status().isUnauthorized());
    }
}