package LaboratoryBank.AccountType;

import LaboratoryBank.Bancking.Account;

public class CheckingAccount extends Account {


    // *Costo manejo mensual */
    protected double commission;

    public CheckingAccount(int number, int balance, double commission) {
        super(number, balance);
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "commission=" + commission +
                 super.toString() +
                '}';
    }


}
