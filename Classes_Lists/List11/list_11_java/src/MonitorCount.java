class IntCellMonitor {
    private int n = 0;
    private boolean modificationOccurred = true;

    public synchronized int getN() {
        while (!modificationOccurred)
            waitForUnlock();
        modificationOccurred = false;
        notifyAll();
        return n;
    }

    public synchronized void setN(int n) {
        while (modificationOccurred)
            waitForUnlock();
        this.n = n;
        modificationOccurred = true;
        notifyAll();
    }

    private void waitForUnlock() {
        try {
            wait();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }
}

class MonitorCount extends Thread {
    private static IntCellMonitor n = new IntCellMonitor();

    @Override
    public void run() {
        int temp;
        for (int i = 0; i < 200000; i++) {
            temp = n.getN();
            n.setN(temp + 1);
        }
    }

    public static void main(String[] args) {
        MonitorCount monitor1 = new MonitorCount();
        MonitorCount monitor2 = new MonitorCount();
        monitor1.start();
        monitor2.start();
        try {
            monitor1.join();
            monitor2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The value of n is " + n.getN());
    }
}