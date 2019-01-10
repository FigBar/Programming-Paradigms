package philosophers_problem;

import java.util.concurrent.Semaphore;

public class Stick {
    private final Semaphore locker;
    private int index;

    Stick(int index) {
        this.locker = new Semaphore(1);
        this.index = index;
    }

    void take() throws InterruptedException {
        locker.acquire();
    }

    void release() {
        locker.release();
    }

    public int getIndex() {
        return index;
    }
}
