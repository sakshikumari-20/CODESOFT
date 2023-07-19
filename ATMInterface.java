import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simulated user accounts
        String[][] accounts = {
                { "123456789", "1234", "1000" },
                { "987654321", "4321", "500" },
                { "111111111", "0000", "1500" }
        };

        boolean loggedIn = false;
        String currentAccountNumber = "";

        while (true) {
            if (!loggedIn) {
                System.out.println("=== ATM Interface ===");
                System.out.println("1. Login");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter your account number: ");
                        String accountNumber = scanner.nextLine();
                        System.out.print("Enter your PIN: ");
                        String pin = scanner.nextLine();

                        if (validateAccount(accounts, accountNumber, pin)) {
                            loggedIn = true;
                            currentAccountNumber = accountNumber;
                            System.out.println("Login successful.");
                        } else {
                            System.out.println("Invalid account number or PIN. Please try again.");
                        }
                        break;

                    case 2:
                        System.out.println("Exiting ATM. Thank you for using our services.");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } else {
                System.out.println("\n=== ATM Menu ===");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Deposit Money");
                System.out.println("4. Logout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        checkBalance(accounts, currentAccountNumber);
                        break;

                    case 2:
                        System.out.print("Enter the amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine();
                        withdrawMoney(accounts, currentAccountNumber, withdrawAmount);
                        break;

                    case 3:
                        System.out.print("Enter the amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine();
                        depositMoney(accounts, currentAccountNumber, depositAmount);
                        break;

                    case 4:
                        loggedIn = false;
                        currentAccountNumber = "";
                        System.out.println("Logout successful.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
    }

    // Validate if the provided account number and PIN exist in the accounts array
    private static boolean validateAccount(String[][] accounts, String accountNumber, String pin) {
        for (String[] account : accounts) {
            if (account[0].equals(accountNumber) && account[1].equals(pin)) {
                return true;
            }
        }
        return false;
    }

    // Retrieve and display the account balance
    private static void checkBalance(String[][] accounts, String accountNumber) {
        for (String[] account : accounts) {
            if (account[0].equals(accountNumber)) {
                double balance = Double.parseDouble(account[2]);
                System.out.println("Your account balance is: $" + balance);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    // Withdraw money from the account if sufficient funds are available
    private static void withdrawMoney(String[][] accounts, String accountNumber, double amount) {
        for (String[] account : accounts) {
            if (account[0].equals(accountNumber)) {
                double balance = Double.parseDouble(account[2]);
                if (amount <= balance) {
                    balance -= amount;
                    account[2] = String.valueOf(balance);
                    System.out.println("Withdrawal successful. Remaining balance: $" + balance);
                } else {
                    System.out.println("Insufficient funds.");
                }
                return;
            }
        }
        System.out.println("Account not found.");
    }

    // Deposit money into the account
    private static void depositMoney(String[][] accounts, String accountNumber, double amount) {
        for (String[] account : accounts) {
            if (account[0].equals(accountNumber)) {
                double balance = Double.parseDouble(account[2]);
                balance += amount;
                account[2] = String.valueOf(balance);
                System.out.println("Deposit successful. Updated balance: $" + balance);
                return;
            }
        }
        System.out.println("Account not found.");
    }
}
