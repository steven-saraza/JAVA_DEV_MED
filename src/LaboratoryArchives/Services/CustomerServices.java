package LaboratoryArchives.Services;


import LaboratoryArchives.BankingArchives.Client;

import java.util.List;

public interface CustomerServices {

    boolean addCustomer(Client customer);
    boolean delteCustomer(int number);

    //Consultar cliente
    Client seeCustomer(int number);


    List<Client> getCustomers();
    Client searchCustomerRfc(String rfc);
}
