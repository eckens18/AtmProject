package com.derekeckenroad;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtmTest{

    @Test
    public void createNewUserTest(){

    }

    @Test
    public void chooseSecondaryAccountTest(){
        Atm atm = new Atm();

    }

    @Test
    public void closeAccountTest(){
        Atm atm = new Atm();
        Account checking = new Account();
        checking.setName("checking");
        atm.currentAccount = checking;
        String expected = "You removed the account: checking";
        String actual = atm.closeAccount("checking");
        assertEquals("Should return 'You removed the account: checking'",expected,actual);
    }
}
