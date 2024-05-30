package Services;

import Bancking.Account;

public interface AccountService {

    boolean addAccount(Account account);
    boolean cancelAccount(int number);

    //Abonar cuenta
    boolean updateAccountBalance(int number, double payment);
    boolean removeAccountBalance(int number, double paymentRemove);
    Account getAccount(Account account);
}
