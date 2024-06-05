package LaboratoryStreams.Services;

import LaboratoryStreams.BankingStreams.Client;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public interface CustomerServices {

    boolean addCustomer(Client customer);
    boolean delteCustomer(int number);

    //Consultar cliente
    Client seeCustomer(int number);


    List<Client> getCustomers();
    Client searchCustomerRfc(String rfc);
}
