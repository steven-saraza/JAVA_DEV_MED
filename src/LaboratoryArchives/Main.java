package LaboratoryArchives;

import LaboratoryArchives.AcoountType.CheckingAccount;
import LaboratoryArchives.AcoountType.SavingAccount;
import LaboratoryArchives.BankingArchives.Account;
import LaboratoryArchives.BankingArchives.Bank;
import LaboratoryArchives.BankingArchives.Client;
import LaboratoryArchives.BankingArchives.Domicile;
import LaboratoryArchives.Services.AccountServiceMethod;
import LaboratoryArchives.Services.AccountServices;
import LaboratoryArchives.Services.CustomerServiceMethod;
import LaboratoryArchives.Services.CustomerServices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

        addCliente();

        readAndAsincAccount("F:\\Platzi\\JAVA\\JAVA_DEV_MED\\JAVA_DEV_MED\\JAVA_DEV_MED\\accounts.txt");
    }

    private static void addCliente(){
        // Crear y agregar tres clientes
        Domicile domicile1 = new Domicile("Calle carrera 1", 1094, "Colonia 1", "Estado 1", 1234);
        Domicile domicile2 = new Domicile("Calle carrera 2", 1826, "Colonia 2", "Estado 2", 2345);
        Domicile domicile3 = new Domicile("Calle carrera 3", 1872, "Colonia 3", "Estado 3", 3456);

        Client cliente1 = new Client(1,  domicile1,"Cliente 1", "RFC1", "555-1111", "01-01-1990");
        Client cliente2 = new Client(2,  domicile2,"Cliente 2", "RFC2", "555-2222", "02-02-1991");
        Client cliente3 = new Client(3,  domicile3, "Cliente 3","RFC3", "555-3333", "03-03-1992");

        customerServices.addCustomer(cliente1);
        customerServices.addCustomer(cliente2);
        customerServices.addCustomer(cliente3);

    }

    private static void readAndAsincAccount(String urlArchive){
        try(BufferedReader reader = new BufferedReader(new FileReader(urlArchive))) {
            String line;

            while ((line = reader.readLine()) != null){
                System.out.println(line);

                //El metodo substring toma una posición inicial y una final para tomar y trabajar con esa cadena
                String tipoCuenta = line.substring(0, 2); 

                //se valida que efectivamente inicie con los caracteres extraidos
                if (line.startsWith("CA[") || line.startsWith("CC[")) {
                  
                    line = line.substring(3, line.length() - 1).trim();

                    //se usa para eliminar los espacios en blancos y dividir el contenido de la cadena con base en la coma (,)
                    String[] sements = line.split(",\\s*");

                    if (sements.length == 5) {

                        //Aquí se usan los parseos para convertir los datos de texto del archivo en datos int o Double
                        // y se usa trim para quitar los espacios que se puedan presentar
                        int number = Integer.parseInt(sements[0].trim());
                        String openingDate = sements[1].trim();
                        double balance = Double.parseDouble(sements[2].trim().replace(",", "."));
                        double addicionalParameter = Double.parseDouble(sements[3].trim().replace(",", "."));
                        int numberId = Integer.parseInt(sements[4].trim());

                        //Se identifica la cadena de cuenta de ahorros o cuenta de cheque para guardar lo datos de forma correcta
                        if (tipoCuenta.equals("CA")) {
                            double interestRateMonth = addicionalParameter;
                            SavingAccount savingAccount = new SavingAccount(number, balance, interestRateMonth);
                            accountServices.addAccount(savingAccount);
                            Client client = customerServices.seeCustomer(numberId);
                            if (client != null) {
                                client.getAccounts().add(savingAccount);
                                System.out.println("La cuenta de ahorros se agregó correctamente al cliente " + numberId + ": " + savingAccount);
                            } else {
                                System.out.println("Cliente " + numberId + " no c.");
                            }
                        } else if (tipoCuenta.equals("CC")) {
                            double commission = addicionalParameter;
                            CheckingAccount checkingAccount = new CheckingAccount(number, balance, commission);
                            accountServices.addAccount(checkingAccount);
                            Client client = customerServices.seeCustomer(numberId);
                            if (client != null) {
                                client.getAccounts().add(checkingAccount);
                                System.out.println("La checkingAccount de ahorros se agregó correctamente al client " + numberId + ": " + checkingAccount);
                            } else {
                                System.out.println("Cliente " + numberId + " no encontrado.");
                            }
                        }
                    } else {
                        System.out.println("Formato de línea incorrecto: " + line);
                    }
                } else {
                    System.out.println("Formato de línea incorrecto: " + line);
                }
            }
        } catch (IOException  e) {
            e.printStackTrace();
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("Error al convertir número: " + e.getMessage());
        }


    }
}


