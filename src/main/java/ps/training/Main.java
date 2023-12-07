package ps.training;

import ps.training.banks.HDFC_Bank;
import ps.training.banks.ICICI_Bank;
import ps.training.banks.SBI_Bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    BufferedReader buff;
    InputStreamReader isr;
    public Main() {
        if(isr == null)
            isr = new InputStreamReader(System.in);
        if(buff==null)
            buff = new BufferedReader(isr);
    }

    int selectedBank, selectedOperation;
    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println("\n\nWelcome to IBS!\nPlease select a bank to open an account in.\n1. ICICI\n2. HDFC\n3. SBI");

        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + obj.selectedBank + "\n\n");

        // register user to the selected bank
        Customer customer = new Customer(obj.selectedBank, obj.buff, obj.isr);


        RBI bank = null;
        // create bank account and initialise account balance to zero
        switch(obj.selectedBank) {
            case 1 : bank = new ICICI_Bank(obj.selectedBank, obj.buff, obj.isr);
            case 2 : bank = new HDFC_Bank(obj.selectedBank, obj.buff, obj.isr);
            case 3 : bank = new SBI_Bank(obj.selectedBank, obj.buff, obj.isr);
        }

        do {
            System.out.println("Select your choice\n1. Deposit\n2. Withdrawal\n3. OpenFD\n4. Apply Loan\n5. Apply CC\n0. Exit");
            try {
                obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Customer Selected " + obj.selectedOperation + "\n\n");

            switch(obj.selectedOperation) {
                case 1: bank.depositMoney(); break;
                case 2: bank.withdrawMoney(); break;
                case 3: bank.openFD(); break;
                case 4: bank.getLoan(); break;
                case 5: System.out.println("Selected Apply CC\n\n");
            }
        } while(obj.selectedOperation != 0);
    }
}