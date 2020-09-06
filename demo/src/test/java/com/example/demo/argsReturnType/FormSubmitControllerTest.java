package com.example.demo.argsReturnType;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@RunWith(SpringRunner.class)
class FormSubmitControllerTest {

    @Autowired
    MockMvc mockMvc;

    /**
     * 이벤트 화면 테스트
     * @throws Exception
     */
    @Test
    void eventForm() throws Exception {
        // 이벤트 화면 컨트롤러
        mockMvc.perform(get("/form/events/form"))
                .andDo(print())
                // 이벤트 화면의 이름 확인
                .andExpect(view().name("/FormSubmit/events/Form"))
                // 이벤트 화면시 model의 attribute 확인
                .andExpect(model().attributeExists("event"))
        ;
    }

    @Test
    void getEvent() throws Exception {
        // form 이벤트 테스트하기
        mockMvc.perform(post("/form/events")
                    // 파라미터 정보 보내기
                    .param("name", "test")
                    .param("limit", "1")
                    .param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk()) // 화면 결과
                // 보낸 파라미터 정보를 확인
                .andExpect(jsonPath("name").value("test"))
                .andExpect(jsonPath("limit").value("1"))
                .andExpect(jsonPath("id").value("1"))
        ;

        mockMvc.perform(post("/form/events")
                    .param("name", "test")
                    .param("limit", "kkk")
                    .param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }
}