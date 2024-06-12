package LaboratoryArchives.BankingArchives;

public class Account {

    private int number;
    private String openingDate;
    private double balance;
    private String cancellationDate;

    public Account(int number, double balance){
        this.number = number;
        this.balance = balance;
    }

    public String getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(String cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return " Account{" +
                "number=" + number +
                ", openingDate='" + openingDate + '\'' +
                ", balance=" + balance +
                ", cancellationDate='" + cancellationDate + '\'' +
                '}';
    }
}
