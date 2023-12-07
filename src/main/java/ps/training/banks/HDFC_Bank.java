package ps.training.banks;

import ps.training.RBI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HDFC_Bank implements RBI {
    BufferedReader buff;
    InputStreamReader isr;
    int bankId;
    String bankName;
    float balance;
    float minBalance = 1000;
    float fd_roi = 1.1f;
    // Home Loan - Education Loan - Personal Loan - Car Loan
    float[] loan_roi = {5.5f, 3.4f, 6.3f, 8.2f};


    public HDFC_Bank(int bankId, BufferedReader buff, InputStreamReader isr) {
        this.bankId = bankId;
        this.balance = 0;
        this.buff = buff;
        this.isr = isr;

        while(balance < minBalance) {
            balance = 0;
            System.out.println("You need to deposit a minimum amount of " + minBalance);
            this.depositMoney();
        }
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
        float amount = 0;
        System.out.println("Enter the amount you want to deposit in FD : ");
        try {
            amount = Float.parseFloat(this.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        float resBalance = balance - amount;
        if(resBalance < 0) {
            System.out.println("Insufficient funds to open a FD. ");
            return;
        }

        balance -= amount;
        System.out.println("Succesfully opened an FD of amount INR " + amount);
        System.out.println("Your current balance is : " + balance);

        System.out.println("\nShowing first, second and third year FD projections for the balance of " + amount + " at ROI of " + fd_roi);
        for(int i = 1; i <= 3; i++) {
            System.out.println("For year " + i + ", " + calculateFD(amount, fd_roi , i));
        }
        System.out.println("\n\n");
    }

    public void getLoan() {
        int type = 0;
        System.out.println("Enter the type of loan that you want: \n1. Home Loan\n2. Education Loan\n3. Personal Loan\n4. Car Loan");
        try {
            type = Integer.parseInt(this.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        float roi = loan_roi[type];
        float amount = 0;
        int time = 0;

        System.out.println("Enter the loan amount : ");
        try {
            amount = Float.parseFloat(this.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Enter the tenure of the loan in months : ");
        try {
            time = Integer.parseInt(this.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        // Formula for Loan
//        P x R x (1+R)^N / [(1+R)^N-1] where-
//          P = Principal loan amount
//          N = Loan tenure in months
//          R = Monthly interest rate
        double emi = amount * roi * Math.pow((1 + roi), time) / Math.pow((1 + roi), time);
        System.out.println("You will have to pay an EMI of " + emi);
    }
}
