package com.xiaokunliu.study.springmvc_mybatis.tools;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

/**
 * project:java-code
 * file:ExampleObjectFactory
 * package:com.xiaokunliu.study.springmvc_mybatis.tools
 * date:2019/4/7 10:17 AM
 * author:keithl
 */
public class ExampleObjectFactory extends DefaultObjectFactory {

    // 覆盖对象工厂的方法

    @Override
    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    @Override
    protected Class<?> resolveInterface(Class<?> type) {
        return super.resolveInterface(type);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
