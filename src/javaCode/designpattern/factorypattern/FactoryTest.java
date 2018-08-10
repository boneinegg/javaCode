package javaCode.designpattern.factorypattern;

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
