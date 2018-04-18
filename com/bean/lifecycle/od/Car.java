package SpringStu.com.bean.lifecycle.od;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Car implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean {
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("set brand");
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    private String brand;
    private String color;
    private int maxSpeed;

    private String name;
    private BeanFactory beanFactory;

    public Car(){
        System.out.println("init Car by default constructor");
    }
    public void introduce(){
            System.out.println("brand: "+brand+"color: "+color+"maxSpeed: "+maxSpeed);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException{
        System.out.println("BeanFactoryAware.setBeanFactory");
        this.beanFactory=beanFactory;
    }

    public void setBeanName(String beanName){
        System.out.println("BeanNameAware.setBeanName");
        this.name=beanName;
    }

    public void afterPropertiesSet() throws Exception{
        System.out.println("InitializingBean.afterPropertiesSet");
    }

    public void destroy() throws Exception{
        System.out.println("DisposableBean.destroy()");
    }

    public void myInit(){
        System.out.println("use init-method, set maxspeed to 240");
        this.maxSpeed=240;
    }
    public void myDestroy(){
        System.out.println("use destroy-method");
    }

}
