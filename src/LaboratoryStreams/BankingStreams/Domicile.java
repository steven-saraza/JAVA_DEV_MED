package LaboratoryStreams.BankingStreams;

public class Domicile {

    // **Attributes**
    private String street;
    private int numberStreet;
    private String colony;
    private String state;
    private int postalCode;


    public Domicile(String street, int numberStreet, String colony, String state, int postalCode) {
        this.street = street;
        this.numberStreet = numberStreet;
        this.colony = colony;
        this.state = state;
        this.postalCode = postalCode;
    }

    public int getNumber() {
        return numberStreet;
    }

    public void setNumber(int number) {
        this.numberStreet = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getColony() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "LaboratoryOneTwo.Bancking.Domicile{" +
                "street='" + street + '\'' +
                ", number=" + numberStreet +
                ", colony='" + colony + '\'' +
                ", state='" + state + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
