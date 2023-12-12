import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test_ICICI_Bank {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader buff = new BufferedReader(isr);

    @Test
    public void depositMoney() {
        float balance = 1000;

        float amount = 100;
        System.out.println("Enter the amount you want to deposit : ");
        try {
            amount = Float.parseFloat(this.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
       balance += amount;

        float expectedBalance = 1100;
        float actualBalance = balance;

        Assertions.assertEquals(expectedBalance, actualBalance);
    }
}
