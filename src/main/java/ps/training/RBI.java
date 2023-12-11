package ps.training;

public interface RBI {
    int bankId = 0;
    String bankName = "";
    float balance = 0;
    float fd_roi = 0;
    float loan_roi = 0;
    float minBalance = 0;


    void depositMoney();
    void withdrawMoney();
    void openFD();
    void getLoan();
    int getCustomerCount();
    void displayBalance();

}