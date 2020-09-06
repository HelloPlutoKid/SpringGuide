package com.example.demo.argsReturnType;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/reqParam")
public class ReqParameterController {

    /***
     *
     * @RequestParam
     * 요청 매개변수에 들어있는 단순 타입 데이터를 메소드 아규먼트로 받아올 수 있다.
     * 값이 반드시 있어야 한다(requried는 defalut가 true이기 때문에)
     * String이 아닌 값들은 타입 컨버전을 지원
     * Map<String , String> 또는 MultiValueMap<String, String>에 사용해서 모든 요청 매개변수를 받아 올 수도 있다.
     * 이 애노테이션은 생략할 수 있다.
     */
    @PostMapping("/events")
    @ResponseBody
    public Event getEvent(
            // required defalut true
            @RequestParam(required = true, defaultValue = "1") Integer id,
            @RequestParam String name,
            @RequestParam Integer limit) {
        Event e1 = new Event();
        e1.setId(id);
        e1.setName(name);
        e1.setLimit(limit);
        return e1;
    }

    @PostMapping("/mapEvents")
    @ResponseBody
    public Event getMapEvent(
            @RequestParam Map<String,String> params) {
        Event e1 = new Event();
        e1.setName(params.get("name"));
        return e1;
    }
}
