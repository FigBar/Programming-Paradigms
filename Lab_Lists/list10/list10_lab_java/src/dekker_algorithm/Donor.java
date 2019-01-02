package dekker_algorithm;



public class Donor extends Thread {
    private final BankAccountSem bankAccount;
    private int donationSum;

    Donor(BankAccountSem bankAccount) {
        this.bankAccount = bankAccount;
        this.donationSum = 1000;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void run() {
        while (!bankAccount.isAccountEmpty()) {
            bankAccount.lock();
            int currentBalance = bankAccount.getAccountBalance();
            try {
                Thread.sleep((long) (Math.random() * 40));
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
            bankAccount.setAccountBalance(currentBalance + 100);
            donationSum += 100;
            System.out.println("Donor pays in now: " + bankAccount.getAccountBalance());
            bankAccount.unlock();
            try {
                Thread.sleep((long) (Math.random() * 60));
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }

    int getDonationSum() {
        return donationSum;
    }
}
