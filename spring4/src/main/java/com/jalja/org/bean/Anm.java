package com.jalja.org.bean;

public class Anm {
    public void initAnm(){
        System.out.println("Anm bean的初始化调用");
    }

    public void destroy() throws Exception {
        System.out.println("*********Anm bean的销毁**************");
    }
}
