package PracticeStreamsParallel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    /*
     *
     * */
    public static void main(String[] args) throws InterruptedException {

        //Ejercicio 1
        System.out.println("***** Ejercicio 1 ******");
        parallelStreamsMethod1();
        Thread.sleep(2000);
        System.out.println("***** Ejercicio 1 finalizado ******\n");

        //Ejercicio 2
        System.out.println("***** Ejercicio 2 ******");
        parallalStreamsMethod2();
        Thread.sleep(2000);
        System.out.println("***** Ejercicio 2 finalizado ******\n");

        //Ejercicio 3
        System.out.println("***** Ejercicio 3 ******");
        parallalStreamsMethod3();
        Thread.sleep(2000);
        System.out.println("***** Ejercicio 3 finalizado ******\n");

        //Ejercicio 4
        System.out.println("***** Ejercicio 4 ******");
        parallalStreamsMethod4();
        Thread.sleep(2000);
        System.out.println("***** Ejercicio 4 finalizado ******\n");

        //Ejercicio 5
        System.out.println("***** Ejercicio 5 ******");
        parallalStreamsMethod5();
        Thread.sleep(2000);
        System.out.println("***** Ejercicio 5 finalizado ******\n");
    }

    public static void parallelStreamsMethod1() {

        //IntStream.rangeClosed() = Crea un stream de numeros enteros con un rango definido
        //boxed() = Convierte el stream de numeros enteros a un stream de numeros enteros empaquetados en un objeto
        //toList() = Convierte el stream de numeros enteros empaquetados en un objeto a una lista
        List<Integer> number = IntStream
                .rangeClosed(1, 100)
                .boxed()
                .toList();

        number.parallelStream().forEach(n -> {
            try {
                Thread.sleep(1500);
                System.out.println("Numero: " + n + " - Hilo: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }

    public static void parallalStreamsMethod2() throws InterruptedException {

        //InteStream.rangeClosed() = Crea un stream de numeros enteros con un rango definido
        //mapToObj() = Convierte el stream de numeros enteros a un stream de objetos y dentro de este crea un numero aleatorio por cada stream
        //toList() = Convierte el stream de objetos a una lista
        List<Integer> numbers = IntStream.rangeClosed(1, 200)
                .mapToObj(r -> new Random().nextInt(1, 200))
                .toList();

        //Integer::sum = Suma los numeros de la lista es igual que decir (a,b) -> a + b
        //mapToInt() = Convierte el stream de objetos a un stream de numeros enteros
        System.out.println("Numbers: " + numbers);
        numbers.parallelStream()
                .reduce(Integer::sum)
                .ifPresent(a -> System.out.println("Suma con Parallel: " + a + " - Hilo: " + Thread.currentThread().getName()));
        Thread.sleep(1500);
        numbers.parallelStream()
                .mapToInt(a -> a)
                .average()
                .ifPresent(a -> System.out.println("Promedio con Parallel: " + a + " - Hilo: " + Thread.currentThread().getName()));


        numbers.stream().reduce(Integer::sum).ifPresent(a -> System.out.println("Suma con Stream: " + a + " - Hilo: " + Thread.currentThread().getName()));
        Thread.sleep(1500);
        numbers.stream().mapToInt(a -> a).average().ifPresent(a -> System.out.println("Promedio con stream: " + a + " - Hilo: " + Thread.currentThread().getName()));

    }

    public static void parallalStreamsMethod3() throws InterruptedException {
        List<Integer> numbers = IntStream.rangeClosed(1, 10)
                .boxed()
                .toList();

        numbers.parallelStream()
                .filter(a -> a % 2 == 0)
                .findAny()
                .ifPresent(a -> System.out.println("Numero par parallel: " + a + " - Hilo: " + Thread.currentThread().getName()));
        Thread.sleep(1500);

        numbers.stream()
                .filter(a -> a % 2 == 0)
                .findAny()
                .ifPresent(a -> System.out.println("Numero par streams: " + a + " - Hilo: " + Thread.currentThread().getName()));
    }

    public static void parallalStreamsMethod4(){
        List<Integer> numbers = IntStream.rangeClosed(1, 50)
                .boxed()
                .toList();

        numbers.parallelStream().reduce(Integer::sum).ifPresent(a -> System.out.println("Suma con Parallel: " + a + " - Hilo: " + Thread.currentThread().getName()));

        //toList() = Convierte el stream de objetos a una lista remplaza el metodo collect(Collectors.toList())
        List<String> names = Stream.of("Juan", "Pedro", "Maria", "Luis", "Carlos", "Andres", "Sofia", "Laura", "Camila", "Andrea")
                .toList();

        names.parallelStream().reduce((a, b) -> a + " - " + b).ifPresent(a -> System.out.println("Nombres con Parallel: " + a + " - Hilo: " + Thread.currentThread().getName()));
    }

    public static void parallalStreamsMethod5(){

        Person person = new Person("Juan", 25);
        Person person1 = new Person("Pedro", 30);
        Person person2 = new Person("Maria", 35);
        Person person3 = new Person("Luis", 40);
        Person person4 = new Person("Carlos", 45);

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        personList.parallelStream().reduce((a,b)-> {
            int i= a.getAge() + b.getAge();
            return new Person("Suma Edad" , i);
        }).ifPresent(a -> System.out.println(a.getName() + a.getAge() + " - Hilo: " + Thread.currentThread().getName()));

    }
}