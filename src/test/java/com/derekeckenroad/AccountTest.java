package com.derekeckenroad;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class AccountTest {

    @Test
    public void depositTest(){
        Account acc = new Account();
        acc.setBalance(100);
        String expected = "Deposited 50.0";
        String actual = acc.deposit(50);
        assertEquals("The expected value should be 50",expected,actual);
    }

    @Test
    public void withdrawTest(){
        Account acc = new Account();
        acc.setBalance(100);
        String expected = "Please take your withdraw of 50.0";
        String actual = acc.withdraw(50);
        assertEquals("The expected value should be 50",expected,actual);
    }

    @Test
    public void printTransactionHistoryTest(){
        Account acc = new Account();
        acc.deposit(100);
        String expected = "Deposited 100.0 ";
        String actual = acc.printTransactionHistory();
        assertEquals("The expected printed TransactionHistory should be 'Deposited 100.0'",expected,actual);
    }
}
