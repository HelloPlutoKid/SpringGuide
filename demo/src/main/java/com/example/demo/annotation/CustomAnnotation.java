package com.example.demo.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 * CustomAnnotation.java
 * /custom Controller 생성
 * Runtime 까지 유지
 */
@Documented
// 문서에 그 애노테이션에 대한 정보를 표기할지 결정
@Target({ElementType.METHOD})
// 어디에 사용할 수 있는지를 결정
@Retention(RetentionPolicy.RUNTIME)
//  언제까지 유지할 것인가
//  Source : 소스 코드까지만 유지, 즉 컴파일 하면 해당 애노테이션 정보는 사라진다는 이야기
//  Class : 컴파일 한 .class 파일에도 유지. 즉 런타임 시, 클래스를 메모리로 읽어오면 해당 정보는 사라진다.
//  Runtime : 클래스 메모리에 읽어왔을 떄 까지 유지! 코드에서 이 정보를 바탕으로 특정 로직을 실행 할 수 있다.
@RequestMapping(method = RequestMethod.GET , value = "/custom")
//  커스텀한 애노테이션을 만들 수 있다.
public @interface CustomAnnotation {
}
