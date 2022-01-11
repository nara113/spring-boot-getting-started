package com.study.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //내장 톰캣 구동
public class RestTempleteTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    TestService testService;

    @Test
    void test() {
        given(testService.getName()).willReturn("test");

        String result = testRestTemplate.getForObject("/hello", String.class);
        assertEquals(result, "hi test");
    }

    @Test
    void test2() {
        given(testService.getName()).willReturn("test");

        webTestClient.get().uri("/hello").exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("hi test");
    }
}
