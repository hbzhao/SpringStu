package com.albert.beanfactory;

import com.albert.OD.Car;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class BeanFactoryTest {

    public static void main(String[] args) throws Throwable{
        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        Resource res=resolver.getResource("classpath:beans.xml");
        System.out.println(res.getURL());


        //类似JavaIo的装饰器设计模式
        DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);// reader配置factory
        reader.loadBeanDefinitions(res);//init reader by resource

        System.out.println("Init Bean");

        Car car=factory.getBean("car1",Car.class);
        System.out.println("car bean is ready");
        car.introduce();
    }
}
