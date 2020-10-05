package com.example.demo.junitFormTest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Event {

    @NotBlank
    private String eventName;

    @NotBlank
    private String eventDescription;

    @Min(0)
    private Integer eventCount;

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
/*
*  validation 사용하기 위해서는 pom.xml 추가 요소
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.0.7.Final</version>
</dependency>
* */