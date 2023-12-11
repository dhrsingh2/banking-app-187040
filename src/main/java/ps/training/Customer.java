package ps.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Customer {
    String customerName;
    String customerBank;
    String aadhaarNumber;
    BufferedReader buff;
    InputStreamReader isr;
    float balance;
    HashMap<String, Customer> icici_map, hdfc_map, sbi_map;

    public Customer(int bankId, BufferedReader buff, InputStreamReader isr, HashMap<String, Customer> icici_map, HashMap<String, Customer> hdfc_map, HashMap<String, Customer> sbi_map) {
        this.buff = buff;
        this.isr = isr;

        this.icici_map = icici_map;
        this.hdfc_map = hdfc_map;
        this.sbi_map = sbi_map;

        HashMap<String, Customer> bank_map = null;

        switch(bankId) {
            case 1 :
                this.customerBank = "ICICI";
                bank_map = icici_map;
                break;
            case 2 :
                this.customerBank = "HDFC";
                bank_map = hdfc_map;
                break;
            case 3 :
                this.customerBank = "SBI";
                bank_map = sbi_map;
                break;
        }

        System.out.println("Enter your name : ");

        try {
            customerName = this.buff.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nHey, " + customerName);
        System.out.println("Enter your Aadhaar Card number : ");

        try {
            aadhaarNumber = this.buff.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        if(bank_map.containsKey(aadhaarNumber)) {
            System.out.println("You already have an account in this bank\n");
            return;
        }

        System.out.println("\nPlease make an initial account to start using your account");
        System.out.println("You have successfully opened an account in " + customerBank + "\n");
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    public String getName() {
        return customerName;
    }
    public String getBank() {
        return customerBank;
    }
    public float getBalance() {
        return balance;
    }
}