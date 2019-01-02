package bank_account;

class BankAccount {
    private int accountBalance;
    private boolean isAccountEmpty;

    BankAccount() {
        this.accountBalance = 1000;
        this.isAccountEmpty = false;
    }

    int getAccountBalance() {
        return accountBalance;
    }

    void setAccountBalance(int accountBalance) {
        if (accountBalance >= 0) {
            this.accountBalance = accountBalance;
            if (accountBalance == 0)
                this.isAccountEmpty = true;
        }
    }

    boolean isAccountEmpty() {
        return isAccountEmpty;
    }
}
