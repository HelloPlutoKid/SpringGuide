package com.example.demo.argsReturnType;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;
import java.io.Reader;
import java.io.Writer;

/**
 * --------------------------------------------------------
 * WebRequset  요청 또는 응답 자체에 접근 가능한 API
 * NativeWebRequest
 * ServletRequest(Response)
 * HttpServletRequest(Response)
 * --------------------------------------------------------
 * 요청 본문을 읽어오거나, 응답 본문을 쓸 떄 사용할 수 있는 API
 * InputStream
 * Reader
 * OutputStream
 * Writer
 * --------------------------------------------------------
 * 스프링 5, HTTP/2 리소스 푸쉬에 사용
 * PushBuilder
 * --------------------------------------------------------
 * GET , POST ... 등에 대한 정보
 * HttpMethod
 * --------------------------------------------------------
 * LocaleResolver가 분석한 요청의 Locale 정보
 * Locale
 * TimeZone
 * ZoneId
 * --------------------------------------------------------
 * URI 템플릿 변수 읽을 떄 사용
 *
 * @PathVariable --------------------------------------------------------
 * URI 템플릿 변수 읽을 떄 사용
 * @MatrixVariable --------------------------------------------------------
 * 서블릿 요청 매개변수 값을 선언한 메소드 아규먼트 타입으로 변환
 * 단숱 타입인 경우에 이 어노테이션을 생략할 수 있다.
 * @RequestParam --------------------------------------------------------
 * 요청 헤더 값을 선언한 메소드 아규컨트 타입으로 변환
 */


@Controller
@RequestMapping("/args")
public class ArgumentController {
//
//    @GetMapping("/events")
//    @ResponseBody
//    public String events(
//            WebRequest requests,
//            NativeWebRequest nativeWebRequest,
//            HttpServletRequest httpServletRequest,
//            HttpServletResponse httpServletResponse
//    ) {
//        // webRequest와 nativeWebRequest 차이는 Spring의 제공 여부
//        // httpServletRequest.getParameter()
//        return "events";
//    }
//
//    @GetMapping("/events")
//    @ResponseBody
//    public String events(
//            Reader reader, Writer writer
//    ) {
//        return "events";
//    }
//
//    @GetMapping("/events")
//    @ResponseBody
//    public String events(
//            PushBuilder pushBuilder
//    ) {
//        // 요청이 들어왔을 떄, pushBuilder를 통한 미리 요청을 처리함
//        return "events";
//    }
//
//    @RequestMapping(value = "/events", method = {RequestMethod.GET, RequestMethod.HEAD})
//    @ResponseBody
//    public String events(
//            HttpMethod httpMethod
//    ) {
////        httpMethod.matches("get")
//        return "events";
//    }

//    @GetMapping(value = "/events")
//    @ResponseBody
//    public String events(
//            Locale locale , TimeZone timeZone , ZoneId zoneId
//    ){
//        return "events";
//    }

//    @GetMapping(value = "/events")
//    @ResponseBody
//    public ResponseEntity<String> events(
//            Locale locale , TimeZone timeZone , ZoneId zoneId
//    ){
//        //RestAPI을 훨씬 복합적으로 생성하기위해서 사용
//        ResponseEntity<Object> build = ResponseEntity.ok().build();
//        return "events";
//    }

//    @GetMapping(value = "/events")
//    @ResponseBody
//    public ResponseEntity<String> events(
//            Locale locale, TimeZone timeZone, ZoneId zoneId
//    ) {
//        //RestAPI을 훨씬 복합적으로 생성하기위해서 사용
//        ResponseEntity<Object> build = ResponseEntity.ok().build();
//        return "events";
//    }


}

