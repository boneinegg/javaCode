package javaCode.thread;

public class Hero {
    private String name;
    private float hp;
    private int damage;

    public Hero(String name, float hp, int damage) {
        this.damage = damage;
        this.hp = hp;
        this.name = name;
    }

    public void attackHero(Hero hero) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hero.hp -= damage;
        System.out.printf("%s正在攻击%s, %s的血量变成了%.0f%n", name, hero.name, hero.name, hero.hp);

        if (hero.isDead())
            System.out.printf("%s死亡！%n", hero.name);
    }

    public boolean isDead() {
        return hp <= 0 ? true : false;
    }
}
