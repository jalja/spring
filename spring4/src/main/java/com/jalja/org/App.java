package com.jalja.org;

import com.jalja.org.bean.*;
import com.jalja.org.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String [] args){
        AnnotationConfigApplicationContext config=new AnnotationConfigApplicationContext(AppConfig.class);
        MyBean bean=(MyBean) config.getBean("myBean");
       // MyBean bean1=config.getBean(MyBean.class);
        System.out.println(bean);


        //使用 MyFactoryBean 获取MyPerson 这个 bean
        MyPerson myPerson=(MyPerson)config.getBean("myFactoryBean");
        MyPerson myPerson2=config.getBean(MyPerson.class);
        System.out.println(myPerson);


        //获取MyFactoryBean 本身bean
        MyFactoryBean myFactoryBean=(MyFactoryBean)config.getBean("&myFactoryBean");
        MyFactoryBean myFactoryBean1FactoryBean=config.getBean(MyFactoryBean.class);
        System.out.println(myFactoryBean);

        Car car=(Car)config.getBean("car");
        Car car1=config.getBean(Car.class);
        System.out.println(car);


        Anm Anm=(Anm)config.getBean("Anm");
        Anm Anm1=config.getBean(Anm.class);
        System.out.println(Anm);

        config.close();

    }
}
