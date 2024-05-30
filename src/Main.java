import AccountType.CheckingAccount;
import AccountType.SavingAccount;
import Bancking.Account;
import Bancking.Bank;
import Bancking.Client;
import Bancking.Domicile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        // * Creando Cuentas
        CheckingAccount checkingAccountClient = new CheckingAccount(9753, 150000, 100);
        SavingAccount savingAccountClient = new SavingAccount(782347, 15690000, 150);

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(checkingAccountClient);
        accounts.add(savingAccountClient);

        CheckingAccount checkingAccountClien1 = new CheckingAccount(123235, 150000, 100);
        SavingAccount savingAccountClient1 = new SavingAccount(127824, 15690000, 150);

        ArrayList<Account> accounts1 = new ArrayList<>();
        accounts1.add(checkingAccountClient);
        accounts1.add(savingAccountClient);
        // *****************

        // * Crendo Cliente
        Client client = new Client(986767849, new Domicile("Calle cliente", 123, "Colonia cliente", "Estado Cliente", 12345),
                "Marcelo","rfc", "1563282", accounts, "12/12/1990");

        Client client1 = new Client(389192863, new Domicile("Calle cliente 1 ", 123, "Colonia cliente 1 ", "Estado Cliente 1", 12345),
                "Juan","rfc", "1563282", accounts1, "11/05/1980");



        TreeSet<Client> clients = new TreeSet<>(client);
        clients.add(client);
        clients.add(client1);

        Bank bank = new Bank(new Domicile("Calle banco", 123, "Colonia banco", "Estado banco", 12345),"BancoDePrueba",
                "rfc banco", "phone banco", clients);


        System.out.println("************Account Sevice****************");
        System.out.println("Agregar Cuenta:");
        //boolean addAcount = client.addAccount(new CheckingAccount(123, 150000, 100));
        //System.out.println(addAcount + "\n");

        System.out.println("Cancelar Cuenta:");
        boolean cancelAccount = client.cancelAccount(savingAccountClient1.getNumber());
        System.out.println(cancelAccount + "\n");

        System.out.println("Abonar a Cuenta:");
        boolean updateAccountBalance = client.updateAccountBalance(checkingAccountClien1.getNumber(), 35000.0);
        System.out.println(updateAccountBalance + "\n");

        System.out.println("Retirar de Cuenta:");
        boolean removeAccountBalance = client.removeAccountBalance(savingAccountClient.getNumber(), 49000.35);
        System.out.println(removeAccountBalance + "\n");

        System.out.println("Mostrar Cuenta:");
        Account getAccount = client.getAccount(savingAccountClient);
        System.out.println("La cuenta consultada es: " + getAccount.toString());
        System.out.println("***************************************\n");


        System.out.println("************Customer Sevice****************");
        System.out.println("Agregar Cliente:");
        boolean addCustomer = bank.addCustomer(new Client(389192863, new Domicile("Calle cliente 1 ", 123, "Colonia cliente 1 ", "Estado Cliente 1", 12345),
                "Pedro","rfc", "1563282", accounts, "11/05/1980"));
        System.out.println(addCustomer + "\n");

        System.out.println("Eliminar Cliente:");
        //boolean deleteCustomer = bank.delteCustomer(bank.getClients().contains(client));
        //System.out.println(deleteCustomer + "\n");


        System.out.println("Mostrar Cliente:");
       // Client seeCustomer =  bank.seeCustomer(bank.getClients()[0].getId());
       // System.out.println(seeCustomer + "\n");

        System.out.println("Obtener Cliente:");
        //Client getCustomers = bank.getCustomers(bank.getClients()[0]);
       // System.out.println(getCustomers + "\n");

        System.out.println("Buscar cliente por rfc:");
        Client searchCustomer = bank.searchCustomer("rfc");
        System.out.println(searchCustomer);
        System.out.println("***************************************\n");




        printBankInformation(bank);

    }

    public static void printBankInformation(Bank bank) {
        System.out.println("Nombre Banco: " + bank.getName() + "\n"
                + "RFC Banco: " + bank.getRfc() + "\n"
                + "Telefono Banco: " + bank.getPhone() + "\n"
                + "Domicilio Banco: " + "[\n"
                + "Calle: " + bank.getDomicile().getStreet() + "\n"
                + "Numero: " + bank.getDomicile().getNumber() + "\n"
                + "Colonia: " + bank.getDomicile().getColony() + "\n"
                + "Estado: " + bank.getDomicile().getState() + "\n"
                + "Codigo Postal: " + bank.getDomicile().getPostalCode() + "\n"
           //     + "  ]\n" + "  Cliente: " + bank.getClients()[0].getName() + " [\n"
                + "              Domicilio: " + "[\n"
             //   + "                Calle: " + bank.getClients()[0].getDomicile().getStreet() + "\n"
             //   + "                Numero: " + bank.getClients()[0].getDomicile().getNumber() + "\n"
             //   + "                Estado: " + bank.getClients()[0].getDomicile().getState() + "\n"
             //   + "                Codigo Postal: " + bank.getClients()[0].getDomicile().getPostalCode() + "\n"
                + "              ]\n"
             //   + "            RFC: " + bank.getClients()[0].getRfc() + "\n"
             //   + "            Fecha de Nacimiento: " + bank.getClients()[0].getBirthDate() + "\n"
              //  + "            Telefono: " + bank.getClients()[0].getPhone() + "\n"
                + "\n"
                + "            Cuentas: " + "[\n"
               // + "            Numero: " + bank.getClients()[0].getAccounts().get(0).getNumber() + "\n"
               // + "            Balance: " + bank.getClients()[0].getAccounts().get(0).getBalance() + "\n"
               // + "            Tipo de cuenta 1: " + bank.getClients()[1].getAccounts().get(0) + "\n"
               // + "            Tipo de cuenta 2: " + bank.getClients()[1].getAccounts().get(1) + "\n"
                + "            ]\n"
               // + "  ]\n" + "  Cliente: " + bank.getClients()[1].getName() + "[\n"
                + "              Domicilio: " + "[\n"
               // + "                Calle: " + bank.getClients()[1].getDomicile().getStreet() + "\n"
                //+ "                Numero: " + bank.getClients()[1].getDomicile().getNumber() + "\n"
              //  + "                Colonia: " + bank.getClients()[1].getDomicile().getColony() + "\n"
                //+ "                Estado: " + bank.getClients()[1].getDomicile().getState() + "\n"
              //  + "                Codigo Postal: " + bank.getClients()[1].getDomicile().getPostalCode() + "\n"
                + "           ]\n"
               // + "            RFC: " + bank.getClients()[1].getRfc() + "\n"
               // + "            Fecha de Nacimiento: " + bank.getClients()[1].getBirthDate() + "\n"
                //+ "            Telefono: " + bank.getClients()[1].getPhone() + "\n"
                + "\n"
                + "            Cuentas: " + "[\n"
               // + "            Numero: " + bank.getClients()[1].getAccounts().get(0).getNumber() + "\n"
               // + "            Balance: " + bank.getClients()[1].getAccounts().get(0).getBalance() + "\n"
                //+ "            Tipo de cuenta 1: " + bank.getClients()[1].getAccounts().get(0) + "\n"
               // + "            Tipo de cuenta 2: " + bank.getClients()[1].getAccounts().get(1) + "\n"
                + "            ]\n"
                + "  ]\n"

        );
    }
}