package javaCode.designpattern.factorypattern;

class HumanFactory {
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

class SingleTon {
    private static SingleTon s;
    private SingleTon() {}

    public static SingleTon getInstance() {
        if (s == null)
            return new SingleTon();
        return s;
    }
}
public class FactoryTest {
    public static void main(String[] args) {
        HumanFactory humanFactory = new HumanFactory();
        //1
        String gender = "Female";
        Human female1 = humanFactory.createHuman(gender);
        female1.eat();
        female1.sleep();
        female1.beat();

        //2
        Female female2 = humanFactory.createFemale2();
        female2.eat();
        female2.sleep();
        female2.beat();

        //3
        Female female3 = HumanFactory.createFemale3();
        female3.eat();
        female3.sleep();
        female3.beat();
    }
}
