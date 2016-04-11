package com.acumensolutions.bank;

import account.CheckingAccount;
import account.SavingsAccount;
import account.Account;

public class AcumenBank {

    public static void main(String[] args) {
        System.out.println("Welcome to Acumen Bank!");
        System.out.println();

        CheckingAccount michaelsAccount = new CheckingAccount("Michael", 5000);
        CheckingAccount gobsAccount = new CheckingAccount("Gob", 2000);

        System.out.println("Open Accounts:");
        System.out.println();
        printAccountDetails(michaelsAccount);
        System.out.println();
        printAccountDetails(gobsAccount);

        System.out.println();
        System.out.println("Making transfer of $1000...");
        try {
                Thread.sleep(500);
        } catch (InterruptedException e) {
                return;
        }

        michaelsAccount.transfer(gobsAccount, 1000);

        System.out.println("Updated Account Details:");
        System.out.println();
        printAccountDetails(michaelsAccount);
        System.out.println();
        printAccountDetails(gobsAccount);

        // sample code for savings account implementation

        System.out.println();
        System.out.println("Open Savings Accounts:");
        System.out.println();
        
        // Initialize new savings account with initial balance of $30,000 and 0.89% interest
        SavingsAccount acesSavingsAccount = new SavingsAccount("Ace", 30000, .0089);

        SavingsAccount garysSavingsAccount = new SavingsAccount("Gary", 10000, .0056);

        printSavingsAccountDetails(acesSavingsAccount);
        printSavingsAccountDetails(garysSavingsAccount);

        System.out.println();
        System.out.println("Making transfer of $5000...");
        System.out.println();
        try {
                Thread.sleep(500);
        } catch (InterruptedException e) {
                return;
        }
        acesSavingsAccount.transfer(garysSavingsAccount, 5000);
        System.out.println("Updated Account Details:");
        System.out.println();
        printSavingsAccountDetails(acesSavingsAccount);
        System.out.println();
        printSavingsAccountDetails(garysSavingsAccount);

        // apply 2 years of interest to the savings accounts
        acesSavingsAccount.applyInterest(2);
        garysSavingsAccount.applyInterest(2);

        System.out.println();
        System.out.println("Interest accrued after two years from initial deposit balance");
        printSavingsAccountDetails(acesSavingsAccount);
        System.out.println();
        printSavingsAccountDetails(garysSavingsAccount);

        System.out.println();
        System.out.println("Open Account:");
        System.out.println();

        SavingsAccount michaelsSavingsAccount = new SavingsAccount("Michael", 700, .0079);
        printSavingsAccountDetails(michaelsSavingsAccount);
        System.out.println();
        System.out.println("Check balance of checking:");
        System.out.println();
        printAccountDetails(michaelsAccount);

        System.out.println("Making transfer of $300...");
        try {
                Thread.sleep(500);
        } catch (InterruptedException e) {
                return;
        }
        
        System.out.println();
        michaelsAccount.transfer(michaelsSavingsAccount, 300);

        System.out.println("Updated Account Details:");
        System.out.println();
        printAccountDetails(michaelsAccount);
        System.out.println();
        printSavingsAccountDetails(michaelsSavingsAccount);
        System.out.println();

    }

    private static void printAccountDetails(Account account) {
        System.out.format("Account for %s:\r\n", account.getOwnerName());
        System.out.format("Balance: $%.2f\r\n", account.getBalance());
    }

    private static void printSavingsAccountDetails(SavingsAccount account){
        System.out.format("Savings ");
        printAccountDetails(account);
        System.out.format("Interest Rate:%.4f\r\n", account.getInterestRate());
        System.out.format("Interest: $%.2f\r\n", account.getInterest());

    }
}