package javaCode.designpattern.factorypattern;

public class HumanFactory {
    //普通工厂模式
    public Human createHuman(String gender) {
        if (gender.equals("Female"))
            return new Female();
        else if (gender.equals("Male"))
            return new Male();
        else
            System.out.println("请输入正确性别类型！");
        return null;
    }

    //多个工厂方法模式
    public Male createMale2() {
        return new Male();
    }
    public Female createFemale2() {
        return new Female();
    }

    //静态工厂方法模式
    public static Male createMale3() {
        return new Male();
    }
    public static Female createFemale3() {
        return new Female();
    }

}
