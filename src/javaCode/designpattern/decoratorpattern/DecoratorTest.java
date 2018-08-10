package javaCode.designpattern.decoratorpattern;

abstract class Girl {
    String description = "no particular";

    public String getDescription() {
        return description;
    }
}

class ChineseGirl extends Girl {
    public ChineseGirl() {
        description = "Chinese girl";
    }
}

abstract class GirlDecorator extends Girl {
    public abstract String  getDescription();
}

class Tall extends GirlDecorator {
    private Girl girl;
    public Tall(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String getDescription() {
        return girl.getDescription() + " is very tall";
    }
}

public class DecoratorTest {
    public static void main(String[] args) {
        Girl girl = new ChineseGirl();
        System.out.println(girl.getDescription());
        GirlDecorator girlDecorator = new Tall(girl);
        System.out.println(girlDecorator.getDescription());
    }

}
