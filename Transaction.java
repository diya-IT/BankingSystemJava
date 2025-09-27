import java.util.Date;

class Transaction {
    private int accNo;
    private String type; // Deposit, Withdraw
    private double amount;
    private Date date;

    public Transaction(int accNo, String type, double amount) {
        this.accNo = accNo;
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return date + " - AccNo: " + accNo + ", " + type + ": " + amount;
    }
}
