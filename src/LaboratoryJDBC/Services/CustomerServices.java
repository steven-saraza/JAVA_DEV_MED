package LaboratoryJDBC.Services;


import LaboratoryJDBC.BankingJDBC.Client;

import java.util.List;

public interface CustomerServices {

    boolean addCustomer(Client customer);
    boolean delteCustomer(int number);

    //Consultar cliente
    Client seeCustomer(int number);


    List<Client> getCustomers();
    Client searchCustomerRfc(String rfc);
}
