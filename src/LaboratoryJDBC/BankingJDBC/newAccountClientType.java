package LaboratoryJDBC.BankingJDBC;


import java.util.ArrayList;

public class newAccountClientType {

    private ArrayList<Account> accountss = new ArrayList<>();
    private int client;
    private String typeAccout;

    public newAccountClientType(int client, String typeAccout, ArrayList<Account> accountss) {
        this.client = client;
        this.typeAccout = typeAccout;
        this.accountss = accountss;
    }

    public ArrayList<Account> getAccoun() {
        return accountss;
    }

    public void setAccoun(ArrayList<Account> accoun) {
        this.accountss = accoun;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public String getTypeAccout() {
        return typeAccout;
    }

    public void setTypeAccout(String typeAccout) {
        this.typeAccout = typeAccout;
    }
}
