import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public String deposit(double amount) {
        balance += amount;
        return "Deposited " + amount + ". New balance: " + balance;
    }

    public String withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return "Withdrawn " + amount + ". New balance: " + balance;
        } else {
            return "Insufficient funds";
        }
    }

    public String checkBalance() {
        return "Current balance: " + balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.print("Enter your choice: ");
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("******************** WELCOME TO OUR ATM INTERFACE ********************");
            System.out.println("\nATM Menu:");
            displayOptions();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    System.out.println(account.withdraw(withdrawAmount));
                    break;
                case "2":
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    System.out.println(account.deposit(depositAmount));
                    break;
                case "3":
                    System.out.println(account.checkBalance());
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial account balance: ");
        double initialBalance = Double.parseDouble(scanner.nextLine());

        BankAccount account = new BankAccount(initialBalance);
        ATM atm = new ATM(account);
        atm.start();
    }
}
