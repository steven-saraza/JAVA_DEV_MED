package LaboratoryOneTwo.AccountType;

import LaboratoryOneTwo.Bancking.Account;

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
