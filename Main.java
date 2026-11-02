class BankAccount {
    String accountNumber;
    String accountHolder;
    double balance;

    // Parameterized constructor
    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: ₹" + balance);
    }
}

// SavingsAccount inherits BankAccount
class SavingsAccount extends BankAccount {
    double interestRate;

    // Parameterized constructor
    SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Method overriding
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// CurrentAccount inherits BankAccount
class CurrentAccount extends BankAccount {
    double overdraftLimit;

    // Parameterized constructor
    CurrentAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Method overriding
    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Overdraft Limit: ₹" + overdraftLimit);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        BankAccount account1 =
            new BankAccount("1001", "Rahul", 5000.0);

        SavingsAccount account2 =
            new SavingsAccount("2002", "Sneha", 8000.0, 4.5);

        CurrentAccount account3 =
            new CurrentAccount("3003", "Arjun", 12000.0, 3000.0);

        account1.displayDetails();
        System.out.println();

        account2.displayDetails();
        System.out.println();

        account3.displayDetails();
    }
}