package philosophers_problem;

import java.util.concurrent.Semaphore;

public class FivePhilosophersProblem {
    public static void main(String[] args) {
        final Stick[] sticksArray = new Stick[5];
        final Philosopher[] philosophersArray = new Philosopher[5];
        final Semaphore deadlockPrecaution = new Semaphore(4, true);

        for (int i = 0; i < 5 ; i++) {
            sticksArray[i] = new Stick(i);
        }

        for (int i = 0; i < 5 ; i++) {
            philosophersArray[i] = new Philosopher(sticksArray[i], sticksArray[(i+1)%5], deadlockPrecaution, i);
        }

        for (Philosopher philosopher: philosophersArray) {
            philosopher.start();
        }
    }
}
