package Bancking;

import Services.AccountService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Client implements AccountService , Comparator<Client>{

    private int id;
    private String name;
    private Domicile domicile;
    private String rfc;
    private String phone;
    private ArrayList<Account> accounts;
    private String birthDate;

    public Client(int id,Domicile domicile, String name, String rfc, String phone, ArrayList<Account> accounts, String birthDate) {
        this.id = id;
        this.domicile = domicile;
        this.name = name;
        this.rfc = rfc;
        this.phone = phone;
        this.accounts = accounts;
        this.birthDate = birthDate;
    }

    public Client()
    {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Domicile getDomicile() {
        return domicile;
    }

    public void setDomicile(Domicile domicile) {
        this.domicile = domicile;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }



    @Override
    public boolean addAccount(Account account) {

        if (account != null) {
            ArrayList<Account> newAccounts ;
            newAccounts = new ArrayList<>(accounts.size() + 1);
            for (int i = 0; i < accounts.size(); i++) {
                newAccounts.add(accounts.get(i));
            }
            newAccounts.set(accounts.size(), account);
            System.out.print("Cuenta agregada: " + account.toString() + "  ");
            accounts = newAccounts;
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelAccount(int number) {
        if (number != 0) {
            System.out.print("Cuenta cancelada: " + number + "  ");
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAccountBalance(int number, double payment) {
        if (number != 0) {
            System.out.print("Se ha abonado a la cuenta: " + number + ", Un saldo de: " + payment + "  ");
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAccountBalance(int number, double paymentRemove) {
        if (number != 0) {
            System.out.print("Se ha retirado de la cuenta: " + number + ", Un saldo de: " + paymentRemove + "  ");
            return true;
        }
        return false;
    }

    @Override
    public Account getAccount(Account account) {
        return account;
    }


    @Override
    public int compare(Client o1, Client o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }

    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", domicile=" +// domicile +
                ", rfc='" + rfc + '\'' +
                ", phone='" + phone + '\'' +
                ", accounts=" + Arrays.toString(new ArrayList[]{accounts}) +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }



}
