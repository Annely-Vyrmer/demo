package ee.bcs.valiit.tasks;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Lesson4 {
    // Store account nr as a key and account balance as value
    // HashMap<String, Account> accountBalanceMap = new HashMap<>();
    private static final Map<String, Double> accountBalanceMap = new HashMap<String, Double>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Choose action you wish to do: \n" +
                    "1. Create Account\n" +
                    "2. Get Balance\n" +
                    "3. Deposit Money\n" +
                    "4. Withdraw Money\n" +
                    "5. Transfer Money\n" +
                    "6. Exit\n" +
                    "*********************");
            String actionNo = scanner.nextLine();            //saab kasutada ka "String line = scanner.nextLine();", siis tuleb else/if sees kasutada.....
            if (actionNo.equalsIgnoreCase("Exit") || actionNo.equals("6")) {
                System.out.println("You have exited the program.");
                break;
                // TODO 1
                // Add command: "createAccount ${accountNr}"
                // this has to store accountNr with 0 balance
            } else if (actionNo.equalsIgnoreCase("Create Account") || actionNo.equals("1")) {
                System.out.println("Please enter new account number:");
                String accountNr = scanner.nextLine();
                System.out.println("Please enter balance: ");
                Double balance = scanner.nextDouble();
                scanner.nextLine();
                accountBalanceMap.put(accountNr, balance);
                System.out.println("Your new account number is: " + accountNr + ". \n" +
                        "Current account balance is euro: " + balance + " euro.");
                // TODO 2
                // Add command: "getBalance ${accountNr}"
                // this has to display account balance of specific account
            } else if (actionNo.equalsIgnoreCase("Get Balance") || actionNo.equals("2")) {
                System.out.println("Please enter account number: ");
                String accountNr = scanner.nextLine();
                Double balance = accountBalanceMap.get(accountNr);
                if (accountBalanceMap.get(accountNr) == null) {
                    System.out.println("No account with this account number. Please create new account.");
                } else {
                    System.out.println("Your account (" + accountNr + ") balance is " + balance + " euro. " +
                            "What would you like to do next?\n" +
                            "*********************");
                }
                // TODO 3
                // Add command: "depositMoney ${accountNr} ${amount}
                // this has to add specified amount of money to account
                // You have to check that amount is positive number
            } else if (actionNo.equalsIgnoreCase("Deposit Money") || actionNo.equals("3")) {
                System.out.println("Please advise account number");
                String accountNr = scanner.nextLine();
                Double balance = accountBalanceMap.get(accountNr);
                System.out.println("Your account (" + accountNr + ") balance is " + balance + " euro.");
                System.out.println("Please insert amount you would like to deposit: ");
                Double deposit = scanner.nextDouble();
                scanner.nextLine();
                if (accountBalanceMap.get(accountNr) == null) {
                    System.out.println("No account found. Please create new account.");
                } else if (deposit > 0) {
                    balance = balance + deposit;
                    System.out.println("Your account (" + accountNr + ") new balance is " + balance + " euro.");
                    accountBalanceMap.put(accountNr, balance);
                } else {
                    System.out.println("Invalid amount. You can deposit positive amount.");
                }
                // TODO 4
                // Add command: "withdrawMoney ${accountNr} ${amount}
                // This has to remove specified amount of money from account
                // You have to check that amount is positive number
                // You may not allow this transaction if account balance would become negative
            } else if (actionNo.equalsIgnoreCase("Withdraw money") || actionNo.equals("4")) {
                System.out.println("Please advise account number");
                String accountNr = scanner.nextLine();
                System.out.println("Please advise amount you would like to withdraw: ");
                Double withdraw = scanner.nextDouble();
                Double balance = accountBalanceMap.get(accountNr);
                scanner.nextLine();
                if (withdraw < accountBalanceMap.get(accountNr)) {
                    balance = balance - withdraw;
                    accountBalanceMap.replace(accountNr, balance);
                    System.out.println("You have withdrawn " + withdraw + " euro. Your account remaining amount is: " + balance);
                } else if (withdraw > balance) {
                    System.out.println("You don´t have sufficient funds.");
                } else {
                    System.out.println("Invalid input.");
                }
                // TODO 5
                // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
                // This has to remove specified amount from fromAccount and add it to toAccount
                // Your application needs to check that toAccount is positive
                // And from account has enough money to do that transaction
            } else if (actionNo.equalsIgnoreCase("Transfer Money") || actionNo.equals("5")) {
                System.out.println("Please insert account number you would like to transfer money FROM:");
                String fromAccountNr = scanner.nextLine();
                Double balance = accountBalanceMap.get(fromAccountNr);
                System.out.println("Your account (" + fromAccountNr + ") balance is: " + balance);
                System.out.println("Please advise amount you would like to transfer: ");
                Double transfer = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Please insert account number you would like to transfer money TO:");
                String toAccountNr = scanner.nextLine();
                if (transfer > accountBalanceMap.get(fromAccountNr)) {
                    System.out.println("You don´t have sufficient funds to transfer.");
                } else if (transfer <= accountBalanceMap.get(fromAccountNr)) {
                    balance = accountBalanceMap.get(fromAccountNr);
                    double account2Balance = accountBalanceMap.get(toAccountNr);
                    double deductedMoney = balance - transfer;
                    double addedMoney = account2Balance + transfer;
                    accountBalanceMap.put(fromAccountNr, deductedMoney);
                    accountBalanceMap.put(toAccountNr, addedMoney);
                    System.out.println("You have transferred: " + transfer + " euro from account " + fromAccountNr + ". Your new balance is: " + deductedMoney + " euro.");
                    System.out.println("Your account " + toAccountNr + " balance is: " + addedMoney + " euro.");
                } else {
                    System.out.println("Invalid input.");
                }
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}
