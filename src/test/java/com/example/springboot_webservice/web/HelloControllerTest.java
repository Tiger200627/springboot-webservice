package com.example.springboot_webservice.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("hello return test")
    public void hello_return() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    @DisplayName("helloDto return test_lombok")
    public void helloDto_return() throws Exception{
        String name = "hello";
        int amount = 2000;

        mockMvc.perform(get("/hello/dto")
                .param("name", name) // API 테스트 시 요청 파라미터 설정,
                .param("amount", String.valueOf(amount))) // 값 String만 허용
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name)) // JSON 응닶값을 필드별로 검증 할 수 있는 메소드 / $를 기준으로 필드명을 명시
                .andExpect(jsonPath("$.amount").value(amount));
    }
}