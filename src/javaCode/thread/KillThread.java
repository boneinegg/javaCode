package javaCode.thread;

public class KillThread extends Thread {
    private Hero attacker;
    private Hero target;

    public KillThread(Hero attacker, Hero target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void run() {
        super.run();
        while (!target.isDead())
            attacker.attackHero(target);
    }
}
