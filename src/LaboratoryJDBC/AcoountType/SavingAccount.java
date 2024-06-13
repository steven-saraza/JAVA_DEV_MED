package LaboratoryJDBC.AcoountType;

import LaboratoryJDBC.BankingJDBC.Account;

public class SavingAccount extends Account {

    private double interestRateMonth;

    public SavingAccount(int number, double balance, double interestRateMonth) {
        super(number, balance);
        this.interestRateMonth = interestRateMonth;
    }

    public double calculateInterest() {
        return (getBalance() * interestRateMonth)/100;
    }

    @Override
    public String toString() {
        return " SavingAccount{" +
                "interestRateMonth=" + interestRateMonth + super.toString() +
                '}' + super.toString();
    }


}
