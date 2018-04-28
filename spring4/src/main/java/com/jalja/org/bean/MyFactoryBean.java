package com.jalja.org.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 使用FactoryBean创建 MyPerson 这个bean
 */
public class MyFactoryBean implements FactoryBean<MyPerson> {

    public MyPerson getObject() throws Exception {
        return new MyPerson();
    }

    public Class<?> getObjectType() {
        return MyPerson.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
