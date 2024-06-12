package LaboratoryArchives.BankingArchives;

import java.util.ArrayList;

public class Bank {

    private String name;
    private String rfc;
    private String phone;
    private Domicile domicile;
    private ArrayList<Client> clients;

    public Bank(Domicile domicile, String name, String rfc, String phone) {


        this.name = name;
        this.rfc = rfc;
        this.phone = phone;
        this.domicile = domicile;
        this.clients = new ArrayList<>();

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

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", rfc='" + rfc + '\'' +
                ", phone='" + phone + '\'' +
                ", domicile=" + domicile +
                ", clients=" + clients +
                '}';
    }

}
