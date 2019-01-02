package bank_account;

public class Recipient extends Thread {
    private final BankAccount bankAccount;
    private int handOutSum;

    Recipient(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.handOutSum = 0;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void run() {
        while(!bankAccount.isAccountEmpty()) {
            int currentBalance = bankAccount.getAccountBalance();
            try {
                Thread.sleep((long)(Math.random() * 20));
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
            bankAccount.setAccountBalance(currentBalance - 100);
            handOutSum += 100;
            System.out.println("Recipient pays out now: " + bankAccount.getAccountBalance());
            try {
                Thread.sleep((long)(Math.random() * 40));
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }

    int getHandOutSum() {
        return handOutSum;
    }
}
