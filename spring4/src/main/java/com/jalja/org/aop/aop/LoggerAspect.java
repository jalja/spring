package com.jalja.org.aop.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect  
@Component
public class LoggerAspect {
    /** 
     * 前置通知的注解，在目标方法执行前调用 
     * execution最基础的表达式语法。 
     * 注意点： 
     * 1. 方法里面不能有行参，及add(int a, int b) 这是会报错的。 
     * 2. int（方法的返回值），add（方法名） 可以用 * 抽象化。甚至可以将类名抽象，指定该包下的类。 
     * 3. (int, int) 可以用(..)代替，表示匹配任意数量的参数 
     * 4. 被通知的对象（Target），建议加上包的路径 
     */  
    @Before("execution(* com.jalja.org.aop.bean.ComputeService.*(..))")  
    public void beforeAdvice(JoinPoint joinPoint) {  
        /** 
         * 连接点 joinPoint：add方法就是连接点 
         * getName获取的是方法名，是英文的，可以通过国际化转换对应的中文比较好。 
         */  
        String methodName = joinPoint.getSignature().getName();   
        List<Object> args = Arrays.asList(joinPoint.getArgs());  
        System.out.println("@Before 前置通知 : 方法名 【 " + methodName + " 】and args are " + args);  
    }  
    
    /** 
     * 后置通知的注解, 在目标方法执行后调用，即使是程序出错都会调用 
     * 这里将 方法的返回值 和 ComputeService类下所有的方法，以及方法的形参 都抽象了 
     */  
    @After("execution(* com.jalja.org.aop.bean.ComputeService.*(..))")  
    public void afterAdvice(JoinPoint joinPoint) {  
        String methodName = joinPoint.getSignature().getName();   
        List<Object> args = Arrays.asList(joinPoint.getArgs());  
        System.out.println("@After 后置通知 : 方法名 【 " + methodName + " 】and args are " + args);  
    }  
      
    /** 
     * 重用切入点定义：声明切入点表达式。该方法里面不建议添加其他代码 
     */  
    @Pointcut("execution(* com.jalja.org.aop.bean.ComputeService.*(..))")  
    public void declareExecutionExpression(){}  
      
    /** 
     * 返回通知的注解, 在目标方法成功执行后调用，如果程序出错则不会调用 
     * returning="result" 和 形参 result 保持一致 
     */  
    @AfterReturning(value="declareExecutionExpression()", returning="result")  
    public void afterRunningAdvice(JoinPoint joinPoint, Object result) {  
        String methodName = joinPoint.getSignature().getName();   
        List<Object> args = Arrays.asList(joinPoint.getArgs());  
        System.out.println("@AfterReturning 返回通知 : 方法名 【 " + methodName + " 】and args are " + args + " , result is " + result);  
    }  
      
    /** 
     * 异常通知的注解, 在目标方法出现指定异常时调用 
     * throwing="exception" 和 形参 exception 保持一致 ， 且目标方法出了Exception（可以是其他异常）异常才会调用。 
     */  
    @AfterThrowing(value="declareExecutionExpression()", throwing="exception")  
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception exception) {  
        String methodName = joinPoint.getSignature().getName();   
        System.out.println("@AfterThrowing 异常通知 : 方法名 【 " + methodName + " 】and  exception is " + exception);  
    }  
    
}
