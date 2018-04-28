package com.jalja.org.config;

import com.jalja.org.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Configuration 注解 bean容器
 */
@Configuration
public class AppConfig {


    //@Bean 创建bean 默认bean的名字是方法名
    // @Scope：指定bean的模式  默认singleton    prototype：每次都新创建  该模式不会调用bean的destroy()方法
    @Bean(name = "myBean")
    @Scope("singleton")
    public MyBean createMyBena(){
        return new MyBean();
    }
    @Bean(name = "myFactoryBean")
    public MyFactoryBean gerMyFactoryBean(){
        return new MyFactoryBean();
    }


    @Bean(name = "carFactory")
    public CarFactory getCarFactory(){
        return new CarFactory();
    }

    @Bean(name = "car")
    public Car getCar(CarFactory carFactory){
        return carFactory.createCar();
    }

    @Bean(name = "Anm",initMethod = "initAnm",destroyMethod="destroy")
    public Anm createAnm(){
        return new Anm();
    }
}
