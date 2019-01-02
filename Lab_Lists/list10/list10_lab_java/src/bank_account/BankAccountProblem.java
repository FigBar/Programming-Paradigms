package bank_account;

public class BankAccountProblem {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        Donor donor = new Donor(account1);
        Recipient recipient = new Recipient(account1);

        donor.start();
        recipient.start();

        try {
            donor.join();
            recipient.join();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
        System.out.println("Account sum from donor's perspective: " + donor.getDonationSum());
        System.out.println("Account sum from recipient's perspective: " + recipient.getHandOutSum());
    }
}
