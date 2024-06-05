package LaboratoryStreams.AcoountType;

import LaboratoryStreams.BankingStreams.Account;

public class CheckingAccount extends Account {


    // *Costo manejo mensual */
    protected double commission;

    public CheckingAccount(int number, double  balance, double commission) {
        super(number, balance);
        this.commission = commission;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "commission=" + commission +
                '}' +super.toString();
    }
}
