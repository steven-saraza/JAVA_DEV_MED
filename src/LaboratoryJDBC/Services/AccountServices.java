package LaboratoryJDBC.Services;

import LaboratoryJDBC.BankingJDBC.Account;

public interface AccountServices {

    boolean addAccount(Account account, int id, String typeAccount, double interestRateMonthOrCommision);
    boolean cancelAccount(int number);

    //Abonar cuenta
    boolean updateAccountBalance(int number, double payment);
    boolean removeAccountBalance(int number, double paymentRemove);
    void getAccount();
}
