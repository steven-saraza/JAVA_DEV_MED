package LaboratoryBank.Services;
import LaboratoryBank.Bancking.Client;

public interface CustomerService {

    boolean addCustomer(Client customer);
    boolean delteCustomer(int number);
    Client seeCustomer(int number);
    Client getCustomers(Client customer);
    Client searchCustomer(String rfc);
}
