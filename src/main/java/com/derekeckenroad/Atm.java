package com.derekeckenroad;

import java.util.ArrayList;
import java.util.Scanner;

public class Atm {

    Scanner sc = new Scanner(System.in);
    User currentUser;
    public Account currentAccount;
    boolean flag = true;
    boolean loginAcceptedStatus = false;
    ArrayList<User> possibleUsers = new ArrayList<User>();

    public void runLoginScreen() {
        System.out.println("Hello welcome to EckenBank ATM");
        while (flag) {
            System.out.println("Press 1:login 2:set up account 3:exit");
            int haveAccount = sc.nextInt();
            switch (haveAccount) {
                case 1:
                    runMenu();
                    break;
                case 2:
                    createNewUser();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("sorry not an option");
            }
        }
    }

    public void login() {
        System.out.println("Please enter user name");
        String enteredName = sc.next();
        System.out.println("Please enter 4 digit pin associated with user");
        String enteredPin = sc.next();

        if (possibleUsers == null) {
            createNewUser();
        } else {
            for (User user : possibleUsers) {
                if (user.getUserName().equals(enteredName) && user.getPassword().equals(enteredPin)) {
                    currentUser = user;
                    this.loginAcceptedStatus = true;
                } else {
                    System.out.println("Sorry, user name and password did not match please re-enter info or create a new account");
                    runLoginScreen();
                }
            }
        }
    }

    public void runMenu() {
        login();
        while (loginAcceptedStatus) {
            System.out.println("Choose an option\n" +
                    "1:create account 2:choose account  3:deposit       4:withdraw\n" +
                    "5:transfer       6:close account   7:check balance 8:print transaction history\n" +
                    "9:transfer->user 10:back to login");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    createNewAccount();
                    break;
                case 2:
                    System.out.println("do you want to choose checking, savings, or investment");
                    String chosenAccount = sc.next();
                    chooseAccount(chosenAccount);
                    break;
                case 3:
                    System.out.println("please enter amount to deposit");
                    double depositAmount = sc.nextDouble();
                    currentAccount.deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("please enter amount to withdraw");
                    double withdrawAmount = sc.nextDouble();
                    currentAccount.withdraw(withdrawAmount);
                    break;
                case 5:
                    System.out.println("please enter amount to be transferred");
                    double transferAmount = sc.nextDouble();
                    System.out.println("now enter account to be transferred to: checking, savings, investment");
                    String transferAccount = sc.next();
                    transferAcrossAccounts(transferAmount,chooseSecondaryAccount(transferAccount));
                    break;
                case 6:
                    break;
                case 7:
                    currentAccount.checkBalance();
                    break;
                case 8:
                    System.out.println(currentAccount.printTransactionHistory());
                    break;
                case 9:
                    break;
                case 10:
                    runLoginScreen();
                    break;
                default:
                    System.out.println("Sorry not an option");
            }
        }
        runLoginScreen();
    }

    public void createNewUser() {
        System.out.println("Please create user name");
        String name = sc.next();
        System.out.println("now set your 4 digit password");
        String pass = sc.next();
        currentUser = new User(name, pass);
        possibleUsers.add(currentUser);
        createNewAccount();

    }

    public void createNewAccount() {
        System.out.println("Choose account to create:\n" +
                "1:Checking 2:Savings 3:Investment");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                Account checking = new Account();
                currentUser.accountList.add(checking);
                checking.setName("checking");
                currentAccount = checking;
                break;
            case 2:
                Account savings = new Account();
                currentUser.accountList.add(savings);
                savings.setName("savings");
                currentAccount = savings;
                break;
            case 3:
                Account investment = new Account();
                currentUser.accountList.add(investment);
                investment.setName("investment");
                currentAccount = investment;
                break;
            default:
                System.out.println("sorry, not an option");
        }
    }

    public void chooseAccount(String accountType){
        for (Account account : currentUser.accountList){
            if(account.getName().equals(accountType)){
                currentAccount = account;
            }
        }
    }

    public Account chooseSecondaryAccount(String accountType){
        Account temp = null;
        for (Account account : currentUser.accountList){
            if(account.getName().equals(accountType)){
                temp = account;
            }
        }
        return temp;
    }

    public void transferAcrossAccounts(double amount, Account accountName) {
        for (Account account : currentUser.accountList) {
            if (account.getName().equals(accountName.getName())) {
                currentAccount.balance -= amount;
                accountName.balance += amount;
                currentAccount.addToTransactionHistory("Transferred " + amount + " to " + accountName.getName());

            }
        }
    }

    

    public String closeAccount(String accountToBeClosed){
        return "";
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }
}
