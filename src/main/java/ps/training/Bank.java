package ps.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bank {
    int bankId;
    String bankName;
    float balance;
    BufferedReader buff;
    InputStreamReader isr;

    public Bank(int bankId, BufferedReader buff, InputStreamReader isr) {
        this.bankId = bankId;
        this.balance = 0;
        this.buff = buff;
        this.isr = isr;
    }

    public void getAccountDetails() {
        System.out.println(bankId);
        System.out.println(bankName);
    }

    public float calculateFD(float amt, float roi, int yrs) {
        for(int i = 0; i < yrs; i++) {
            amt += amt * roi / 100;
        }
        return amt;
    }

    public void depositMoney() {
        float amount = 0;
        System.out.println("Enter the amount you want to deposit : ");
        try {
           amount = Float.parseFloat(this.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        balance += amount;
        System.out.println("Current balance : " + balance + "\n");
    }
    public void withdrawMoney(){
        float amount = 0;
        System.out.println("Enter the amount you want to withdraw : ");
        try {
            amount = Float.parseFloat(this.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        if(balance - amount < 0) {
            System.out.println("Insufficient funds in the account! Cancelling withdrawal\n\n");
            return;
        }

        balance -= amount;
        System.out.println("Current balance : " + balance + "\n");
    }

    public void openFD() {
        System.out.println("Showing first, second and third year FD projections for the balance of 1000 at ROI of 2.5%\n\n");
        for(int i = 1; i <= 3; i++) {
            System.out.println("For year " + i + ", " + calculateFD(1000, 2, i));
        }
    }
}
