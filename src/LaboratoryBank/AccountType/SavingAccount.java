package LaboratoryBank.AccountType;

import LaboratoryBank.Bancking.Account;

public class SavingAccount extends Account{

    private double interestRateMonth;

    public SavingAccount(int number, int balance, double interestRateMonth) {
        super(number, balance);
        this.interestRateMonth = interestRateMonth;
    }

    public void calculateInterest() {
        // TODO
    }

    @Override
    public String toString() {
        return " SavingAccount{" +
                "interestRateMonth=" + interestRateMonth + super.toString() +
                '}';
    }


}
