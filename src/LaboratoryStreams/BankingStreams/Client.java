package LaboratoryStreams.BankingStreams;

import java.util.ArrayList;


public class Client {

    private int id;
    private String name;
    private Domicile domicile;
    private String rfc;
    private String phone;
    private ArrayList<Account> accounts;
    private String birthDate;

    public Client(int id,Domicile domicile, String name, String rfc, String phone, String birthDate) {
        this.id = id;
        this.domicile = domicile;
        this.name = name;
        this.rfc = rfc;
        this.phone = phone;
        this.accounts = new ArrayList<>();
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Domicile getDomicile() {
        return domicile;
    }

    public void setDomicile(Domicile domicile) {
        this.domicile = domicile;
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

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", domicile=" + domicile +
                ", rfc='" + rfc + '\'' +
                ", phone='" + phone + '\'' +
                ", accounts=" + accounts +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }


}
