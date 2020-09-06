package com.example.demo.junitFormTest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@RunWith(SpringRunner.class)
class FormControllerTest {

    @Autowired
    MockMvc mockMvc;

    /**
     * 이벤트 화면 테스트
     * @throws Exception
     */
    @Test
    void formEvent() throws Exception {
        // 이벤트 화면 테스트하기
        mockMvc.perform(get("/junitForm/formEvent"))
                .andDo(print())
                // 이벤트 화면 이름 확인하기
                .andExpect(view().name("/junit/FormTest/formEvent"))
                // 이벤트 화면의 model 정보 확인하기
                .andExpect(model().attributeExists("event"))
        ;
    }

    @Test
    void regEvent() throws Exception {
        // 이벤트 regEvent 확인하기
//        mockMvc.perform(post("/junitForm/regEvent")
//                    // 파라미터 정보
//                    .param("eventName", "testEvent")
//                    .param("eventDescription", "이벤트를 테스트합니다")
//                    .param("eventCount", "12")
//                )
//                .andDo(print())
//                // 파라미터 정보 검증하기
//                .andExpect(jsonPath("eventName").value("testEvent"))
//                .andExpect(jsonPath("eventDescription").value("이벤트를 테스트합니다"))
//                .andExpect(jsonPath("eventCount").value("12"))
//                .andExpect(status().isOk())
//        ;

//        // 이벤트 regEvent 확인하기
//        mockMvc.perform(post("/junitForm/regEvent")
//                // eventCount는 숫자가 되어야 하나 String 값이 들어가서 바인딩 에러가 발생한다.
//                .param("eventName", "testEvent")
//                .param("eventDescription", "이벤트를 테스트합니다")
//                .param("eventCount", "바인딩 에러 만들기")
//                )
//        ;

        // 이벤트 regEvent 확인하기
         ResultActions result  = mockMvc.perform(post("/junitForm/regEvent")
                // eventCount는 숫자가 되어야 하나 String 값이 들어가서 바인딩 에러가 발생한다.
                .param("eventName", "testEvent")
                .param("eventDescription", "이벤트를 테스트합니다")
                .param("eventCount", "바인딩 에러 만들기")
                )
            .andDo(print())
            .andExpect(status().isOk())
        ;

        ModelAndView mav = result.andReturn().getModelAndView();
        Map<String,Object> model = mav.getModel();
        System.out.println(model.size());
    }
}