package ps.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Customer {
    String customerName;
    String customerBank;
    // String customerEmail;
    BufferedReader buff;
    InputStreamReader isr;

    public Customer(int bankId, BufferedReader buff, InputStreamReader isr) {
        this.buff = buff;
        this.isr = isr;

        switch(bankId) {
            case 1 : customerBank = "ICICI"; break;
            case 2 : customerBank = "HDFC"; break;
            case 3 : customerBank = "SBI"; break;
        }

        System.out.println("Enter your name : ");

        try {
            customerName = this.buff.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Hey, " + customerName + ". You have successfully opened an account in " + customerBank + ". Please make an initial account to start using your account.\n\n");
    }


}