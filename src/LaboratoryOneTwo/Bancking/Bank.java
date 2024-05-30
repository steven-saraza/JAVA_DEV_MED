package LaboratoryOneTwo.Bancking;

import LaboratoryOneTwo.Services.CustomerService;

import java.util.Arrays;
import java.util.TreeSet;

public class Bank implements CustomerService {

    private String name;
    private String rfc;
    private String phone;
    private Domicile domicile;
    private TreeSet<Client> clients;

    public Bank(Domicile domicile, String name, String rfc, String phone, TreeSet<Client> clients) {


        this.name = name;
        this.rfc = rfc;
        this.phone = phone;
        this.domicile = domicile;
        this.clients = clients;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Domicile getDomicile() {
        return domicile;
    }

    public void setDomicile(Domicile domicile) {
        this.domicile = domicile;
    }

    public TreeSet<Client> getClients() {
        return clients;
    }

    public void setClients(TreeSet<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", rfc='" + rfc + '\'' +
                ", phone='" + phone + '\'' +
                ", domicile=" + domicile +
                ", clients=" + Arrays.toString(new TreeSet[]{clients}) +
                '}';
    }


    @Override
    public boolean addCustomer(Client client) {
       return true;
    }

    @Override
    public boolean delteCustomer(int number) {
        if(number != 0){
            System.out.println("El cliente con Cédula: " + number+ "Se ha eliminado");
            return true;
        }
        return false;
    }

    @Override
    public Client seeCustomer(int number) {
        return null;
    }

    @Override
    public Client getCustomers(Client customer) {
        return customer;
    }

    @Override
    public Client searchCustomer(String rfc) {
        if(rfc != null){
            System.out.println("Cliente encontrado con el RFC: " + rfc);
        }
        return null;
    }
}
