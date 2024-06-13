package LaboratoryJDBC.Services;

import LaboratoryJDBC.AcoountType.CheckingAccount;
import LaboratoryJDBC.AcoountType.SavingAccount;
import LaboratoryJDBC.BankingJDBC.Account;
import LaboratoryJDBC.BankingJDBC.Bank;
import LaboratoryJDBC.ConnectDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountServiceMethod implements AccountServices {

    private Bank bank;

    private final List<Account> accounts = new ArrayList<>();

    public AccountServiceMethod(Bank bank) {
        this.bank = bank;
    }

    private ConnectDb connctionBD = new ConnectDb();
    static private PreparedStatement ps = null;

    @Override
    public boolean addAccount(Account account , int idClient, String typeAccount, double interestRateMonthOrCommision) {

        try (Connection connection = connctionBD.getConnectionDB()) {
            try {

                String query = "INSERT INTO Accounts(number, date, balance, interestRateMonth, client, accountType) VALUE (? , ?, ?, ?, ?, ? )";
                ps = connection.prepareStatement(query);
                ps.setInt(1, account.getNumber());
                ps.setString(2, String.valueOf(account.getOpeningDate()));
                ps.setDouble(3, account.getBalance());
                ps.setDouble(4, interestRateMonthOrCommision);
                ps.setInt(5, idClient);
                ps.setString(6, typeAccount);


                ps.executeUpdate();
                System.out.println("Cuenta creado correctamente en la base de datos\n");
                return true;

            } catch (SQLException e) {
                System.out.println("No pudo registrar el cliente" + e);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
        //return accounts.add(account);
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
    public void getAccount() {

        ResultSet response = null;
        int idClient = 0;

        try (Connection connection = connctionBD.getConnectionDB()) {

            String query = "SELECT * FROM Accounts";
            ps = connection.prepareStatement(query);
            response = ps.executeQuery();
            Account account;
            while (response.next()){
                if(response.getString("accountType").equals("CA")){
                    account = new SavingAccount(
                            response.getInt("number"),
                            response.getDouble("balance"),
                            response.getDouble("interestRateMonth")
                    );

                }else {
                    account = new CheckingAccount(
                            response.getInt("number"),
                            response.getDouble("balance"),
                            response.getDouble("interestRateMonth")
                    );
                }
                idClient = response.getInt("client");
                System.out.println("Numero del cliente: " + idClient);
                System.out.println("Tipo de cuenta: " + response.getString("accountType"));
                System.out.println("Información cuenta: " + account + "\n");

            }

        } catch (Exception e) {
            System.out.println("No se pudo recuperar el cliente: " + e);
        }
        //return null;


       // return (ArrayList<Account>) accounts;
        //(ArrayList<Account>) accounts.stream().collect(Collectors.toList());
    }
}
