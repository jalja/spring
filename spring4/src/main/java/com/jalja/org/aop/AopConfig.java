package com.jalja.org.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import com.jalja.org.aop.bean.ComputeService;



/**
 * @Configuration 注解 bean容器
 * @EnableAspectJAutoProxy
 * //开启AspectJ 自动代理模式,如果不填proxyTargetClass=true，默认为false，  
  //即使用jdk默认代理模式，AspectJ代理模式是CGLIB代理模式  
  //如果目标对象实现了接口，默认情况下会采用JDK的动态代理实现AOP   
  //如果目标对象实现了接口，可以强制使用CGLIB实现AOP (此例子我们就是强制使用cglib实现aop)  
  //如果目标对象没有实现了接口，必须采用CGLIB库，spring会自动在JDK动态代理和CGLIB之间转换 
   @ComponentScan: @ComponentScan告诉Spring 哪个packages 的用注解标识的类 会被spring自动扫描并且装入bean容器。
 * 
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages= {"com.jalja.org.aop.aop"})
public class AopConfig {
    //@Bean 创建bean 默认bean的名字是方法名
    // @Scope：指定bean的模式  默认singleton    prototype：每次都新创建  该模式不会调用bean的destroy()方法
    @Bean(name = "computeService")
    @Scope("singleton")
    public ComputeService createComputeService(){
        return new ComputeService();
    }

}
