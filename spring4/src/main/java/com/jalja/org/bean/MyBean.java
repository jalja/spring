package com.jalja.org.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
//一般不用该方式，在配置中指定
public class MyBean implements InitializingBean,DisposableBean{

    //spring容器关闭执行
    public void destroy() throws Exception {
        System.out.println("*********destroy**************");
    }
    //bena创建后执行
    public void afterPropertiesSet() throws Exception {
        System.out.println("*********MyBean bena的初始化**************");
    }
}
