import java.util.concurrent.Semaphore;

class IntCellSemaphore {
    private int n = 0;

    public synchronized int getN() {
        return n;
    }

    public synchronized void setN(int n) {
        this.n = n;
    }
}

class SemaphoreCount extends Thread {
    private static IntCellSemaphore n = new IntCellSemaphore();
    private static Semaphore semaphore = new Semaphore(1);

    @Override
    public void run() {
        int temp;
        for (int i = 0; i < 200000; i++) {
            try {
                semaphore.acquire();
            } catch (InterruptedException exc){
                exc.printStackTrace();
            }
            temp = n.getN();
            n.setN(temp + 1);
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        SemaphoreCount count1 = new SemaphoreCount();
        SemaphoreCount count2 = new SemaphoreCount();
        count1.start();
        count2.start();
        try {
            count1.join();
            count2.join();
        } catch (InterruptedException exc){
            exc.printStackTrace();
        }
        System.out.println("The value of n is " + n.getN());
    }
}