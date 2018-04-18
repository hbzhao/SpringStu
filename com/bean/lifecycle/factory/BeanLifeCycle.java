package SpringStu.com.bean.lifecycle.factory;

import SpringStu.com.bean.lifecycle.od.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;



public class BeanLifeCycle {
    private static void LifeCycleInBeanFactory(){
        //加载配置文件
        Resource res = new ClassPathResource("SpringStu/beans.xml");
        BeanFactory bf=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader((DefaultListableBeanFactory)bf);
        reader.loadBeanDefinitions(res);


        ((DefaultListableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());
        ((DefaultListableBeanFactory) bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        Car car1=(Car)bf.getBean("car");
        car1.introduce();
        car1.setColor("red");

        System.out.println();
        Car car2=(Car)bf.getBean("car2");
        car2.introduce();

        System.out.println();
        Car car3=(Car)bf.getBean("car");
        System.out.println("car3==car1? :" +(car1==car3));
        System.out.println("car2==car1? :" +(car1==car2));

        ((DefaultListableBeanFactory)bf).destroySingleton("car");
        ((DefaultListableBeanFactory)bf).destroySingleton("car2");

    }

    public static void main(String[] args){
        LifeCycleInBeanFactory();
    }
}
