package LaboratoryStreams;

import LaboratoryStreams.AcoountType.CheckingAccount;
import LaboratoryStreams.AcoountType.SavingAccount;
import LaboratoryStreams.BankingStreams.Account;
import LaboratoryStreams.BankingStreams.Bank;
import LaboratoryStreams.BankingStreams.Client;
import LaboratoryStreams.BankingStreams.Domicile;
import LaboratoryStreams.Services.AccountServiceMethod;
import LaboratoryStreams.Services.AccountServices;
import LaboratoryStreams.Services.CustomerServiceMethod;
import LaboratoryStreams.Services.CustomerServices;

import java.util.Scanner;


public class Main {

    private static Bank bank;
    private static AccountServices accountServices;
    private static CustomerServices customerServices;

    public static void main(String[] args) {

        Domicile domicileBank = new Domicile("Calle Carrera", 62365, "Colonia", "Ciudad", 976445);
        Bank bank = new Bank(domicileBank,"Banco Banco de Colombia", "rfc", "23456778");

        customerServices = new CustomerServiceMethod(bank);
        accountServices = new AccountServiceMethod (bank);

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Menu, "+bank.getName());
            System.out.println("1: Menú Cuentas");
            System.out.println("2: Menú Clientes");
            System.out.println("3: Salir");
            option = scanner.nextInt();
            switch (option){
                case 1://caso de menú cuenta
                    menuCount(scanner);
                    break;
                case 2:
                   menuCostumer(scanner);
                    break;
                case 3:
                    System.out.println("Gracias por usar nuestro sistema, saliendo");
                    break;
                default:
                    System.out.println("Opción incorrecta");

            }
        }while (option!=3);scanner.close();
    }


    public static void menuCount(Scanner scanner){
        int optionAccount;
        do {
            System.out.println("Menu, de Cuentas");
            System.out.println("1: Agregar Cuenta");
            System.out.println("2: Cancelar Cuenta");
            System.out.println("3: Abonar Cuenta");
            System.out.println("4: Hacer retiro de cuenta");
            System.out.println("5: Obtener cuentas");
            System.out.println("6: Salir al menú anterior");
            optionAccount = scanner.nextInt();
            switch (optionAccount){
                case 1:
                    addAccount(scanner);
                    break;
                case 2:
                    cancelAccount(scanner);
                    break;
                case 3:
                    updatebalance(scanner);
                    break;
                case 4:
                    removeAccountBalance(scanner);
                    break;
                case 5:
                    getAccounts();
                    break;
                case 6:
                    System.out.println("Saliendo al menú anterior");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }while(optionAccount!=6);

    }

    public static void menuCostumer(Scanner scanner){
        int optionCustomer;
        do {
            System.out.println("Menu, de Cliente");
            System.out.println("1: Agregar Cliente");
            System.out.println("2: Elimina Cliente");
            System.out.println("3: Consultar CLiente");
            System.out.println("4: Obtener Cliente");
            System.out.println("5: Buscar Cliente por RFC");
            System.out.println("6: Salir al menú anterior");
            optionCustomer = scanner.nextInt();
            switch (optionCustomer){
                case 1:
                    addClient(scanner);
                    break;
                case 2:
                    deleteCostumer(scanner);
                    break;
                case 3:
                    seeCostumer(scanner);
                    break;
                case 4:
                    getCustomers();
                    break;
                case 5:
                    searchCustomerRfc(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo al menú anterior");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }while(optionCustomer!=6);

    }

    public static void addAccount(Scanner scanner){
        int optionAccountSC;
            System.out.println("Ingresa el numero de identificación del cliente");
            int numberCliente = scanner.nextInt();
            Client client = customerServices.seeCustomer(numberCliente);

            if(client!=null){
                System.out.println("Que tipo de cuenta quieres agregar");
                System.out.println("1: Cuenta Ahorros");
                System.out.println("2: Cuenta Cheque");

                optionAccountSC = scanner.nextInt();

                System.out.println("Ingrese el numero de cuenta");
                int number = scanner.nextInt();

                System.out.println("Ingrese Saldo Actual");
                double balance = scanner.nextDouble();

                Account account;
                double interestRateMonthOrCommision;
                if (optionAccountSC == 1){
                    System.out.println("Ingrese Tasa de interes mensual");
                    interestRateMonthOrCommision = scanner.nextDouble();
                    account = new SavingAccount(number,balance,interestRateMonthOrCommision);
                }else {
                    System.out.println("Ingrese valor Comisión");
                    interestRateMonthOrCommision = scanner.nextDouble();
                    account = new CheckingAccount(number,balance,interestRateMonthOrCommision);
                }
                client.getAccounts().add(account);

                if (accountServices.addAccount(account)){
                    System.out.println("Cuenta agregada");
                    System.out.println("Quiere agregar otra cuenta?");
                    System.out.println("1: si");
                    System.out.println("2: no");
                    int optionAddMoreAccout = scanner.nextInt();
                    if (optionAddMoreAccout== 1) {
                        addAccount(scanner);
                    }else if(optionAddMoreAccout ==2){
                        System.out.println("Saliendo al menú anterior");
                    }else {
                        System.out.println("opcion incorrrecta");
                    }

                }else {
                    System.out.println("La cuenta no se agregó correctamente");
                }
            }else {
                System.out.println("Cliente no encontrado, debe crearlo primero\n");

            }

    }

    public static void addClient(Scanner scanner){
        System.out.print("Número de identificación: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String name = scanner.nextLine();


        System.out.print("Dirección: ");
        String street = scanner.nextLine();


        System.out.print("Número: ");
        int numberStreet = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Colonia: ");
        String colony = scanner.nextLine();


        System.out.print("Estado: ");
        String state = scanner.nextLine();


        System.out.print("Código Postal: ");
        int postlCode = scanner.nextInt();
        scanner.nextLine();

        System.out.print("RFC: ");
        String rfc = scanner.nextLine();


        System.out.print("Teléfono: ");
        String phone = scanner.nextLine();


        System.out.print("Fecha de Nacimiento: ");
        String birthDate = scanner.nextLine();


        Domicile domicileClient = new Domicile(street,numberStreet,colony,state,postlCode);
        Client client = new Client(number,domicileClient,name,rfc,phone,birthDate);

        if (customerServices.addCustomer(client)){
            System.out.println("Cliente Agregado correctamente");
        }else {
            System.out.println("No se logró agregar al cliente");
        }
    }

    public static void cancelAccount(Scanner scanner){
        System.out.println("Ingresa el numero de cuenta a elmiminar");
        int numberAccount = scanner.nextInt();

        if(accountServices.cancelAccount(numberAccount)){
            System.out.println("Se ha elminado la cuenta\n");
        }else {
            System.out.println("la cuenta no exite\n");
        }

    }

    public static void deleteCostumer(Scanner scanner){
        System.out.println("Ingresa el numero de cliente a eliminar");
        int numberClient = scanner.nextInt();

        if (customerServices.delteCustomer(numberClient)){
            System.out.println("el cliente ha sido eliminado correctamente");
        }else{
            System.out.println("Cliente no existe");
        }
    }

    public static void getAccounts(){
        for (Account account: accountServices.getAccount()){
            System.out.println(account);
        }
    }

    public static void getCustomers(){
        for (Client client: customerServices.getCustomers()){
            System.out.println(client);
            for (Account account: client.getAccounts()){
                System.out.println("\nNumero de cuenta: " + account.getNumber());
            }
        }
    }

    public static void seeCostumer(Scanner scanner){
        System.out.println("Ingresa el numero del cliente que quieres consultar");
        int numberClient= scanner.nextInt();
        Client client = customerServices.seeCustomer(numberClient);

        if(client!=null){
            System.out.println(client);
        }else {
            System.out.println("el cliente no exite");
        }

    }

    public static void searchCustomerRfc(Scanner scanner){
        System.out.println("ingrese el numero RFC que quiere consultar");
        String numberRfc = scanner.next();
        Client client = customerServices.searchCustomerRfc(numberRfc);

        if (client!=null){
            System.out.println(client);
        }else {
            System.out.println("Cliente no encontrado");
        }
    }

    public static void updatebalance(Scanner scanner){
        System.out.println("Ingrese el numero de cuenta");
        int numberAccount = scanner.nextInt();
        System.out.println("Ingrese el monto que desea abonar");
        double payment = scanner.nextDouble();

        if(accountServices.updateAccountBalance(numberAccount,payment)){
            System.out.println("Se abonó correctamente");
        }else {
            System.out.println("No se pudo abonar a la cuenta, no exite o es incorrecta");
        }

    }

    public static void removeAccountBalance(Scanner scanner){
        System.out.println("Ingrese el numero de cuenta");
        int numberAccount = scanner.nextInt();
        System.out.println("Ingrese el monto que desea retirar");
        double removepayment = scanner.nextDouble();

        if(accountServices.removeAccountBalance(numberAccount,removepayment)){
            System.out.println("se hizo el retiro de forma correcta");
        }else{
            System.out.println("No se pudo hacer el retiro , la cuenta no exite o no tiene saldo suficiente");
        }
    }
}


