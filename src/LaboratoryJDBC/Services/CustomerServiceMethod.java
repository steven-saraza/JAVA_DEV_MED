package LaboratoryJDBC.Services;

import LaboratoryJDBC.BankingJDBC.Account;
import LaboratoryJDBC.BankingJDBC.Bank;
import LaboratoryJDBC.BankingJDBC.Client;
import LaboratoryJDBC.BankingJDBC.Domicile;
import LaboratoryJDBC.ConnectDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceMethod implements CustomerServices {

    private Bank bank;
    public CustomerServiceMethod(Bank bank) {
        this.bank = bank;
    }
    private ConnectDb connctionBD = new ConnectDb();
    static private PreparedStatement ps = null;

    @Override
    public boolean addCustomer(Client customer) {
        // * Aun por resolver por qué debo controlar el llamado de la funsión con un
        // try/catch */
        String domicile = customer.getDomicile().getStreet()
                + "-" + customer.getDomicile().getNumber()
                + "-" + customer.getDomicile().getColony()
                + "-" + customer.getDomicile().getState()
                + "-" + customer.getDomicile().getPostalCode();
        try (Connection connection = connctionBD.getConnectionDB()) {
            try {

                String query = "INSERT INTO Customers(id, name, domicile, rfc, phone, birthDate) VALUE (? , ?, ?, ?, ?, ? )";
                ps = connection.prepareStatement(query);
                ps.setString(1, String.valueOf(customer.getId()));
                ps.setString(2, String.valueOf(customer.getName()));
                ps.setString(3, String.valueOf(customer.getDomicile()));
                ps.setString(4, String.valueOf(customer.getRfc()));
                ps.setString(5, String.valueOf(customer.getPhone()));
                ps.setString(6, String.valueOf(customer.getBirthDate()));


                ps.executeUpdate();
                System.out.println("Cliente creado correctamente en la base de datos\n");
                //return true;

            } catch (SQLException e) {
                System.out.println("No pudo registrar el cliente" + e);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        //return false;
        return bank.getClients().add(customer);
    }

    @Override
    public boolean delteCustomer(int number) {
        return bank.getClients().removeIf(a->a.getId()==number);
    }

    @Override
    public Client seeCustomer(int number) {

        ResultSet response = null;

        try (Connection connection = connctionBD.getConnectionDB()) {

            String query = "SELECT * FROM Customers WHERE id = ? ";
            ps = connection.prepareStatement(query);
            ps.setInt(1, number);
            response = ps.executeQuery();


                int idClient = 0;
                String name = "";
                String domicile = null;
                String rfc = "";
                String phone = "";
                String birthDate = "";
                while (response.next()) {
                    idClient =  response.getInt("id");
                    name = response.getString("name");
                    domicile =  response.getString("domicile");
                    System.out.println(domicile);
                    rfc = response.getString("rfc");
                    phone = response.getString("phone");
                    birthDate = response.getString("birthDate");
                }
            if (idClient!=0){
                return new Client(idClient, domicile, name,rfc, phone, birthDate );
            }else {
                System.out.println("el cliente no se ha encontrado en base de datos");
            }


        } catch (Exception e) {
            System.out.println("No se pudo recuperar el cliente: " + e);
        }
        return null;
    }

    @Override
    public List<Client> getCustomers() {
        return bank.getClients().stream()
                .collect(Collectors.toList());
    }

    @Override
    public Client searchCustomerRfc(String rfc) {
        String rfcM = rfc.toUpperCase();
        return bank.getClients().stream().filter(a->a.getRfc().equals(rfcM)).findFirst().orElse(null);
    }
}
