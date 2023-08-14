import java.util.Scanner;

class Account {
    private String userId;
    private String userPin;
    private double balance;

    public Account(String userId, String userPin, double initialBalance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = initialBalance;
    }

    public String getUserId() {
        return userId;
    }

    public boolean validatePin(String pin) {
        return userPin.equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (balance >= amount) {
            balance -= amount;
            recipient.deposit(amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

public class Oasistask3 {
    public static void main(String[] args) {
        Account account = new Account("123456", "1234", 1000.0);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter user PIN: ");
        String pin = scanner.nextLine();

        if (account.getUserId().equals(userId) && account.validatePin(pin)) {
            System.out.println("Login successful.");
            showMenu(account, scanner);
        } else {
            System.out.println("Invalid user ID or PIN.");
        }
    }

    public static void showMenu(Account account, Scanner scanner) {
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Your balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: $" + account.getBalance());
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
                    break;
                case 4:
                    // System.out.print("Enter recipient's user ID: ");
                    // String recipientId = scanner.next();
                    System.out.print("Enter transfer amount: $");
                    double transferAmount = scanner.nextDouble();
                    // For simplicity, assume the recipient's account is the same as the current
                    // account
                    Account recipientAccount = account;
                    account.transfer(recipientAccount, transferAmount);
                    System.out.println("Transfer successful. New balance: $" + account.getBalance());
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
