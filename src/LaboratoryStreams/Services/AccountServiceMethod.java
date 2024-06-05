package LaboratoryStreams.Services;

import LaboratoryStreams.BankingStreams.Account;
import LaboratoryStreams.BankingStreams.Bank;
import PracticeStream.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountServiceMethod implements AccountServices {

    private Bank bank;

    private final List<Account> accounts = new ArrayList<>();

    public AccountServiceMethod(Bank bank) {
        this.bank = bank;
    }

    @Override
    public boolean addAccount(Account account) {
        return accounts.add(account);
    }

    @Override
    public boolean cancelAccount(int number) {
        return accounts.removeIf(c->c.getNumber()==number);
    }

    @Override
    public boolean updateAccountBalance(int number, double payment) {
        return accounts.stream()
                .filter(a->a.getNumber()==number)
                .findFirst()
                .map(a->{
                    a.setBalance(a.getBalance()+payment);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public boolean removeAccountBalance(int number, double paymentRemove) {
        Optional<Account> validateBalance= accounts.stream()
                .filter(a->a.getNumber()==number)
                .filter(a->a.getBalance()<paymentRemove)
                .findAny();

        if(validateBalance.isEmpty()){
            return accounts.stream().filter(a->a.getNumber()==number).findFirst().map(
                            a->{
                                a.setBalance(a.getBalance()-paymentRemove);
                                return true;
                            })
                    .orElse(false);
        }else {
            return false;
        }

    }

    @Override
    public List<Account> getAccount() {
        return accounts.stream().collect(Collectors.toList());
    }
}
