package com.derekeckenroad;

import java.util.ArrayList;
import java.util.Scanner;

public class Account {

    Atm atm = new Atm();
    private String name;
    public double balance;
    private ArrayList<String> transactionHistory = new ArrayList<String>();
    Scanner sc = new Scanner(System.in);

    public void setBalance(double newBalance) {
        balance = newBalance;
    }

    public void checkBalance() {
        System.out.println(balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String withdraw(double withdrawAmount) {
        if (balance <= withdrawAmount) {
            return "Insufficient funds";
        } else {
            balance -= withdrawAmount;
            addToTransactionHistory("Withdraw " + withdrawAmount);
            return "Please take your withdraw of " + withdrawAmount;
        }
    }

    public String deposit(double depositAmount) {
        balance += depositAmount;
        addToTransactionHistory("Deposited " + depositAmount);
        return "Deposited "+depositAmount;
    }

    public void addToTransactionHistory(String transactionUpdate) {
        transactionHistory.add(transactionUpdate);
    }

    public String printTransactionHistory() {
        String printedtrans = "";
        for (String string : transactionHistory) {
            printedtrans += string + " ";
        }
        return printedtrans;
    }
}
