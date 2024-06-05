package LaboratoryStreams.Services;

import LaboratoryStreams.BankingStreams.Account;

import java.util.ArrayList;
import java.util.List;

public interface AccountServices {

    boolean addAccount(Account account);
    boolean cancelAccount(int number);

    //Abonar cuenta
    boolean updateAccountBalance(int number, double payment);
    boolean removeAccountBalance(int number, double paymentRemove);
    List<Account> getAccount();
}
