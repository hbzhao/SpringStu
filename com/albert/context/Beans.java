package SpringStu.com.albert.context;

import SpringStu.com.albert.OD.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//代表这是一个bean的配置类
public class Beans {
    @Bean(name = "car")
    public Car buildCar(){
        Car car=new Car();
        car.setBrand("bmw");
        car.setColor("red");
        car.setMaxSpeed(200);
        return car;
    }
}
