package com.example.demo.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * CustomController.java
 */
@Controller
@RequestMapping("/testAnnotation")
public class CustomController {

    /**
     * /testAnnotation/custom 으로 접근 가능
     * @return
     */
    @CustomAnnotation
    @ResponseBody
    public String custom(){
        return "custom";
    }
}
