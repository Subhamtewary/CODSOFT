import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice) {
        Scanner scanner = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                boolean success = bankAccount.withdraw(withdrawAmount);
                if (success) {
                    System.out.println("Withdrawal successful. Remaining balance: " + bankAccount.getBalance());
                } else {
                    System.out.println("Insufficient funds for withdrawal.");
                }
                break;
            case 2:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                System.out.println("Deposit successful. Updated balance: " + bankAccount.getBalance());
                break;
            case 3:
                System.out.println("Your current balance is: " + bankAccount.getBalance());
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}

public class ATMApp {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Starting balance $1000
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        int choice;
        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            atm.performTransaction(choice);
        }
    }
}
