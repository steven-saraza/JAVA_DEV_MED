package LaboratoryStream;

import java.util.*;
import java.util.stream.Collectors;

public class MainStream {
    public static void main(String[] args) {

        List<Person> listPerson = new ArrayList<>();

        listPerson.add(new Person("Steven", 28, "EDOMEX", 'M'));
        listPerson.add(new Person("Santiago", 29, "NL", 'F'));
        listPerson.add(new Person("Monica", 11, "EDOMEX", 'F'));
        listPerson.add(new Person("Pedro", 41, "CDMX", 'M'));
        listPerson.add(new Person("Maria", 23, "VER", 'M'));
        listPerson.add(new Person("Sol", 12, "OAX", 'F'));
        listPerson.add(new Person("Matias", 30, "CDMX", 'M'));
        listPerson.add(new Person("Carlos", 15, "VER", 'M'));
        listPerson.add(new Person("Cristian", 32, "CDMX", 'M'));
        listPerson.add(new Person("Andrea", 12, "OAX", 'F'));
        listPerson.add(new Person("Lourdes", 11, "EDOMEX", 'F'));


        // * Filtrar y Mostrar
        System.out.println("Personas mayores de 25 Años: ");
        listPerson.stream()
                .filter(a -> a.getAge() > 25)
                .forEach(System.out::println);
        System.out.println("******************************");

        // * Transformación y Agregación
        System.out.println("\nTranformados a mayusculas");
        listPerson.stream()
                .map(a -> a.getName().toUpperCase())
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("******************************");

        // *Ordenación y Depuración
        System.out.println("\nOrdenado por Edad");
        List<Person> groupAge = new ArrayList<>();
        listPerson.stream()
                .sorted((a,b)->Integer.compare(a.getAge(), b.getAge()))
                .peek(System.out::println)
                .forEach(groupAge::add);
        System.out.println("******************************");

        // * Busqueda Condicionada
        System.out.println("\nCualquier las personas de CDMX con mas de 30 años");
        Optional<Person> bc = listPerson.stream()
                .filter(a->a.getCity().equals("CDMX"))
                .filter(a->a.getAge()>30)
                .findAny();
        System.out.println(bc.isPresent() ? bc.get().getName():"No hay") ;

        //Agrupación y Partición
        System.out.println("\nAgrupando personas por ciudad de origen");
        Map<String, List<Person>>  mapAgrupationCity = listPerson.stream().collect(Collectors.groupingBy(Person::getCity));
        mapAgrupationCity.forEach((a,b)->System.out.println("Ciudad: "+a+ " | Persona" + b) );

        System.out.println("\nAgrupando personas con más de 30 y menos de 30");
        Map<Boolean, List<Person>> mapAgruptionAge = listPerson.stream().collect(Collectors.partitioningBy(a->a.getAge()<30));
        mapAgruptionAge.forEach((a,b)->System.out.println("Grupo: "+a+ " | Persona" + b));
        System.out.println("******************************");

        //Operaciones combinadas
        // Personas con genero F menores de 25 años mostradas en minusculas
        System.out.println("\nCombinando operaciones");
        List<Person> newList = new ArrayList<>();
        listPerson.stream()
                .filter(a->a.getGender()=='F')
                .filter(a->a.getAge()<25)
                .map(a -> a.getName().toLowerCase())
                .sorted()
                .forEach(System.out::println);

    }
}
