package PracticeStream;

public class Person implements Comparable<Person> {

    private final String name;
    private final int age;
    private final String city;
    private final char gender;

    public Person(String name,int age, String city, char gender) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public char getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", gender=" + gender +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(getAge(), o.getAge());
    }
}
