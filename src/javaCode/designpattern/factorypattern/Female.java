package javaCode.designpattern.factorypattern;

public class Female implements Human{
    @Override
    public void eat() {
        System.out.println("Female cat eat.");
    }

    @Override
    public void sleep() {
        System.out.println("Female can sleep.");
    }

    @Override
    public void beat() {
        System.out.println("Female cat beat.");
    }
}
