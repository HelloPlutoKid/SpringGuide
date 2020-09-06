package com.example.demo.argsReturnType;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest
@RunWith(SpringRunner.class)
class ReqParameterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getEvent() throws Exception {
        mockMvc.perform(post("/reqParam/events?name=test&limit=20"))
                .andDo(print())
                .andExpect(jsonPath("name").value("test"))
                .andExpect(jsonPath("id").value(1))
        ;

        mockMvc.perform(post("/reqParam/events")
                .param("name", "test")
                .param("limit", "20"))
                .andDo(print())
                .andExpect(jsonPath("name").value("test"))
                .andExpect(jsonPath("id").value(1))
        ;
    }

    @Test
    void getMapEvent() throws Exception {
        mockMvc.perform(post("/reqParam/mapEvents")
                .param("name", "test"))
                .andDo(print())
                .andExpect(jsonPath("name").value("test"));
    }
}