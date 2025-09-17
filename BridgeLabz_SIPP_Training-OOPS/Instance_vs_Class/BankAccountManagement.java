class BankAccountManagement {
    public long accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccountManagement(long accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
    }
}

class SavingsAccount extends BankAccountManagement {
    public SavingsAccount(long accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber + ", Holder: " + accountHolder);
    }
}