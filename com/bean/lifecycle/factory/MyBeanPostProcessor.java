package SpringStu.com.bean.lifecycle.factory;

import SpringStu.com.bean.lifecycle.od.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if(s.equals("car")){
            Car car= (Car) o;
            if(car.getColor()==null){
                System.out.println("use BeanPostProcessor.postProcessBeforeInitialization set color to black");
            }
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if(s.equals("car")){
            Car car= (Car) o;
            if(car.getMaxSpeed()!=200){
                System.out.println("use BeanPostProcessor.postProcessAfterInitialization set speed to 240");
                car.setMaxSpeed(240);
            }
        }
        return o;
    }
}
