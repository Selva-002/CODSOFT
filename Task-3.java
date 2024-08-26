import java.util.InputMismatchException;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited: %.2f%n", amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
        checkBalance();
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrew: %.2f%n", amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
        checkBalance();
    }

    public void checkBalance() {
        System.out.printf("Current balance: %.2f%n", balance);
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner = new Scanner(System.in);

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void run() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            int choice = getUserInput("Choose an option: ");
            
            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    double depositAmount = getUserInputDouble("Enter amount to deposit: ");
                    account.deposit(depositAmount);
                    break;
                case 3:
                    double withdrawAmount = getUserInputDouble("Enter amount to withdraw: ");
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting...");
                  
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private int getUserInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
        }
    }

    private double getUserInputDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); 
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);
        ATM atm = new ATM(account);
        atm.run();
    }
}
