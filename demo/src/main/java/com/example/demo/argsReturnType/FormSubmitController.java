package com.example.demo.argsReturnType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/form")
public class FormSubmitController {

    @GetMapping("/events/form")
    public String eventForm(Model model) {
        Event e1 = new Event();
        e1.setLimit(50);
        e1.setId(50);
        model.addAttribute("event", e1);

        return "/FormSubmit/events/Form";
    }

//    @PostMapping("/events")
//    @ResponseBody
//    public Event event(
//            @RequestParam String name,
//            @RequestParam Integer limit
//    ) {
//        Event e1 = new Event();
//        e1.setLimit(limit);
//        e1.setName(name);
//        return e1;
//    }

    @PostMapping("/events")
    @ResponseBody
    public Event getEvent(
            @Validated @ModelAttribute Event event,
            // 값을 바인딩 할 수 없는 경우네는 BindingResult 4000 에러, 바인딩 되지 못한 값은 null로 처리
            BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()){
            System.out.println("============================================");
            for (ObjectError allError : bindingResult.getAllErrors()) {
                System.out.println(allError.toString());
            }
        }
        return event;
    }
}
