package model;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {

    private BankAccount account = new BankAccount();

    @BeforeEach
    void setUp() {
        System.out.println("Set up log");
        account = new BankAccount();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tear down");
    }

    @Test
    void checkInitialAccountBalanceTest() {
        System.out.println("checkInitialAccountBalanceTest");
        assertEquals(account.getBalance(), 0.0);
    }

    @Test
    void depositMoneyTest() {
        System.out.println("depositMoneyTest");
        account.deposit(10.00);
        assertEquals(account.getBalance(), 10.00);

    }

    @Test
    void withdrawalMoneyTest() {
        System.out.println("withdrawalMoneyTest");
        account.deposit(10.00);
        account.withdraw(6.54);
        assertEquals(account.getBalance(), 3.46);

    }


}
