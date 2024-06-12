package LaboratoryArchives.Services;

import LaboratoryArchives.BankingArchives.Bank;
import LaboratoryArchives.BankingArchives.Client;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceMethod implements CustomerServices {

    private Bank bank;
    public CustomerServiceMethod(Bank bank) {
        this.bank = bank;
    }

    @Override
    public boolean addCustomer(Client customer) {
        return bank.getClients().add(customer);
    }

    @Override
    public boolean delteCustomer(int number) {
        return bank.getClients().removeIf(a->a.getId()==number);
    }

    @Override
    public Client seeCustomer(int number) {
        return bank.getClients().stream()
                .filter(a->a.getId()==number)
                .findFirst()
                .orElse(null);
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
