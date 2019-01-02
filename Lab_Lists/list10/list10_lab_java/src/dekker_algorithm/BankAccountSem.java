package dekker_algorithm;

import java.util.concurrent.Semaphore;

class BankAccountSem {
    private int accountBalance;
    private boolean isAccountEmpty;
    private Semaphore accountLock;

    BankAccountSem() {
        this.accountBalance = 1000;
        this.isAccountEmpty = false;
        this.accountLock = new Semaphore(1);
    }

    synchronized int getAccountBalance() {
        return accountBalance;
    }

    synchronized void setAccountBalance(int accountBalance) {
        if (accountBalance >= 0) {
            this.accountBalance = accountBalance;
            if (accountBalance == 0)
                this.isAccountEmpty = true;
        }
    }

    boolean isAccountEmpty() {
        return isAccountEmpty;
    }

    void lock() {
        try {
            accountLock.acquire();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }

    void unlock() {
        accountLock.release();
    }
}
