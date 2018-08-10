package javaCode.designpattern.factorypattern;

public class Male implements Human {
    @Override
    public void eat() {
        System.out.println("Male cat eat.");
    }

    @Override
    public void sleep() {
        System.out.println("Male cat sleep.");
    }

    @Override
    public void beat() {
        System.out.println("Male cat beat.");
    }
}
