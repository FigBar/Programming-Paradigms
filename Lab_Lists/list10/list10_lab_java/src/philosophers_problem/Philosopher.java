package philosophers_problem;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    private final Stick left, right;
    private final Semaphore deadLockPrevent;

    Philosopher(Stick leftStick, Stick rightStick, Semaphore deadLockPrevent, int index) {
        super("Philosopher " + (index + 1) + ".");
        this.left = leftStick;
        this.right = rightStick;
        this.deadLockPrevent = deadLockPrevent;
    }

    private void eat() throws InterruptedException {
        deadLockPrevent.acquire();
        left.lockStick();
        System.out.println(getName() + "took left stick " + left.getIndex());
        right.lockStick();
        System.out.println(getName() + "took right stick " + right.getIndex());
        System.out.println(getName() + "is eating");
        sleep(50);

        System.out.println(getName() + "put left stick back " + left.getIndex());
        left.unlockStick();

        System.out.println(getName() + "put right stick back " + right.getIndex());
        right.unlockStick();

        deadLockPrevent.release();
        //think();
    }

    private void think() throws InterruptedException {
        System.out.println(getName() + "is thinking.");
        sleep(500);
        System.out.println(getName() + "finished thinking.");
        eat();
    }

    @Override
    public void run() {
        try {
            think();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }
}
