package bank_account;

public class Donor extends Thread {
    private final BankAccount bankAccount;
    private int donationSum;

     Donor(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.donationSum = 1000;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void run() {
        while(!bankAccount.isAccountEmpty()) {
            int currentBalance = bankAccount.getAccountBalance();
            try {
                Thread.sleep((long)(Math.random() * 40));
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
            bankAccount.setAccountBalance(currentBalance + 100);
            donationSum += 100;
            System.out.println("Donor pays in now: " + bankAccount.getAccountBalance());
            try {
                Thread.sleep((long)(Math.random() * 60));
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }

    int getDonationSum() {
        return donationSum;
    }
}
