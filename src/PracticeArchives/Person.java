package PracticeArchives;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 12L;
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.address = address;
        this.age = age;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
