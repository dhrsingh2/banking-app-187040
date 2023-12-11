package ps.training;

import ps.training.banks.HDFC_Bank;
import ps.training.banks.ICICI_Bank;
import ps.training.banks.SBI_Bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main implements Runnable{
    BufferedReader buff;
    InputStreamReader isr;
    int selectedBank, selectedOperation;

    HashMap<String, Customer> icici_map = new HashMap<String, Customer>();
    HashMap<String, Customer> hdfc_map = new HashMap<String, Customer>();
    HashMap<String, Customer> sbi_map = new HashMap<String, Customer>();



    public Main() {
        if(isr == null)
            isr = new InputStreamReader(System.in);
        if(buff==null)
            buff = new BufferedReader(isr);
    }

    public void run() {
        Main obj = new Main();
        int flag = 1;

        do {
            System.out.println("\n\nWelcome to IBS!\nPlease select a bank to open an account in.\n1. ICICI\n2. HDFC\n3. SBI");

            try {
                obj.selectedBank = Integer.parseInt(obj.buff.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Customer Selected " + obj.selectedBank + "\n\n");

            // register user to the selected bank
            Customer customer = new Customer(obj.selectedBank, obj.buff, obj.isr, obj.icici_map, obj.hdfc_map, obj.sbi_map);

            RBI bank = null;
            // create bank account and initialise account balance to zero
            switch(obj.selectedBank) {
                case 1 : bank = new ICICI_Bank(customer, obj.selectedBank, obj.buff, obj.isr, obj.icici_map); break;
                case 2 : bank = new HDFC_Bank(customer, obj.selectedBank, obj.buff, obj.isr, obj.hdfc_map); break;
                case 3 : bank = new SBI_Bank(customer, obj.selectedBank, obj.buff, obj.isr, obj.sbi_map); break;
            }

            // need icici constructor to throw some sort of Exception to take action accordingly after

            do {
                System.out.println("Select your choice\n0. Close session for current customer\n1. Deposit\n2. Withdrawal\n3. OpenFD\n4. Apply Loan\n5. Apply CC\n6. Display current account details \n7. Exit program and Display number of accounts in each bank");
                try {
                    obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Customer Selected " + obj.selectedOperation + "\n");

                switch(obj.selectedOperation) {
                    case 1: bank.depositMoney(); break;
                    case 2: bank.withdrawMoney(); break;
                    case 3: bank.openFD(); break;
                    case 4: bank.getLoan(); break;
                    case 5: System.out.println("Selected Apply CC\n\n");
                    case 6: bank.displayBalance(); break;
                    case 7: flag = 0; break;
                }
            } while(flag == 1 && obj.selectedOperation != 0);
        } while(flag != 0);

        // Display number of bank accounts in each bank
        System.out.println(obj.icici_map.size() + obj.hdfc_map.size() + obj.sbi_map.size());
    }

    public static void main(String[] args) {
        Main obj = new Main();
        Thread th = new Thread(obj);
        th.start();
    }
}

