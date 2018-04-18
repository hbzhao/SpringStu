package SpringStu.com.albert.context;

import SpringStu.com.albert.OD.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnotationApplicationContextTest {
    public static void main(String[] args){
        ApplicationContext ctx=new AnnotationConfigApplicationContext(Beans.class);
        Car car=ctx.getBean("car",Car.class);
        car.introduce();
    }
}
