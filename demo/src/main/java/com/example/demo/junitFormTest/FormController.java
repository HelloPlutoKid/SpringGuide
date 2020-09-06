package com.example.demo.junitFormTest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("junitForm")
public class FormController {
    List<Event> eventList = new ArrayList<>();

    /**
     * 이벤트 등록 화면 컨트롤러
     * @param model
     * @return
     */
    @GetMapping("/formEvent")
    public String formEvent(Model model) {
        // formEvent 화면에 Event 그릇 내려 주기
        model.addAttribute("event", new Event());
        return "/junit/FormTest/formEvent";
    }


    /***
     * 이벤트 정보 확인
     * @param event
     * @param bindingResult
     * @return
     */
//    @PostMapping("/regEvent")
//    @ResponseBody
//    public Event regEvent(
//            @ModelAttribute Event event,
//            // 값을 바인딩 할 수 없는 경우네는 BindingResult 4000 에러
//            // 이벤트 변수 타입이 맞지 않은 경우 null 처리
//            BindingResult bindingResult) {
//        if(bindingResult.hasErrors()){
//            // binding 에러가 된 경우, 에러 종류 찍기
//            for (ObjectError allError : bindingResult.getAllErrors()) {
//                System.out.println(allError.toString());
//            }
//        }
//        return event;
//    }

    @PostMapping("/regEvent")
    public String regEvent(
            @Validated  @ModelAttribute Event event,
            BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            // binding 에러가 된 경우, 에러 종류 찍기
            for (ObjectError allError : bindingResult.getAllErrors()) {
                System.out.println(allError.toString());
            }
            return "/junit/FormTest/formEvent";
        }
        eventList.add(event);
        return "redirect:/junitForm/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(Model model){
        model.addAttribute(eventList);
        return "/junit/FormTest/eventList";
    }
}
