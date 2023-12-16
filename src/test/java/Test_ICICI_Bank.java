import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ps.training.Customer;
import ps.training.banks.ICICI_Bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test_ICICI_Bank {
    InputStreamReader isr;
    BufferedReader buff;
    HashMap<String, Customer> customerMap;
    Customer customer;
    ICICI_Bank bank;

    @BeforeAll
    public void setup() {
        isr = new InputStreamReader(System.in);
        buff = new BufferedReader(isr);
    }

    @Test
    public void testDepositMoney() {
        float initialBalance = 1000;
        float depositAmount = 100;
        float expectedBalance = 1100;

        bank = new ICICI_Bank(initialBalance);

        Assertions.assertEquals(expectedBalance, bank.depositMoney(depositAmount));
    }

    @Test
    public void testWithdrawMoney() {
        float initialBalance = 1000;
        float depositAmount = 100;
        float expectedBalance = 900;

        bank = new ICICI_Bank(initialBalance);

        Assertions.assertEquals(expectedBalance, bank.withdrawMoney(depositAmount));
    }
}

