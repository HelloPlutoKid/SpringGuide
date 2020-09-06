package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZoneId;
import java.util.TimeZone;

@Controller
public class SampleController {

    @GetMapping
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @GetMapping("/oneHello/?")
    @ResponseBody
    public String oneHello(){
        return "oneHello";
    }

    @GetMapping("/multiHello/*")
    @ResponseBody
    public String multiHello(){
        return "multiHello";
    }

    @GetMapping("/multisHello/**")
    @ResponseBody
    public String multisHello(){
        return "multisHello";
    }

//    @GetMapping("/regexHello/{name:[a-z]]+}")
//    @ResponseBody
//    public String regexHello(@PathVariable String name){
//        return "name";
//    }

    @GetMapping("regexHello/{name:[a-z]+}")
    @ResponseBody
    public String regexHello(@PathVariable String name) {
        return name;
    }

    @GetMapping("paramHello")
    @ResponseBody
    public String paramHello(ZoneId zoneId, TimeZone timeZone){
        System.out.println(zoneId);
        System.out.println(timeZone);
        return "hello";
    }

}
