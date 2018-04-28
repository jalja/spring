package com.jalja.org.bean;

import org.springframework.context.annotation.Description;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Car {
    @PostConstruct
    public void initCar(){
        System.out.println("Car bean的初始化调用");
    }
    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("*********Car bean的销毁**************");
    }

}
