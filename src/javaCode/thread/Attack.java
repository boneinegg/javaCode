package javaCode.thread;

public class Attack implements Runnable {
    private Hero attacker;
    private Hero target;

    public Attack(Hero attacker, Hero target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void run() {
        while (!target.isDead())
            attacker.attackHero(target);
    }
}
