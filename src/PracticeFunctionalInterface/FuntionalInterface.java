package PracticeFunctionalInterface;
import java.util.ArrayList;
import java.util.function.*;

public class FuntionalInterface {

    public static void methodStremas(){
            // * Usando Predicate para identificar si un numero es par
            Predicate<Integer> isEven = a -> a % 2 == 0;
            System.out.println(isEven.test(7));

            System.out.println("********");

            // * Lista de nombres
            ArrayList<String> names = new ArrayList<>();
            names.add("Juan");
            names.add("Pedro");
            names.add("Maria");

            // * Usando Consumer para imprimir los nombres
            Consumer<String> printNames = a -> System.out.println("Nombre: " + a);
            names.forEach(printNames);
            System.out.println("********");

            // * Lista de numeros
            ArrayList<Integer> numbers = new ArrayList<>();
            numbers.add(1);
            numbers.add(2);
            numbers.add(3);

            // * Usando Function para elevar al cuadrado los numeros
            Function<Integer, Integer> exponet = a -> (int) Math.pow(a, 2);
            Consumer<Integer> printNumbers = a -> System.out.println("Numero al cuadrado: " + a);
            numbers.forEach(a -> printNumbers.accept(exponet.apply(a)));
            System.out.println("********");


            // * Lista de aleatorios
            ArrayList<Integer> randomNumbers = new ArrayList<>();

            // * Usando Supplier para obtener un numero aleatorio
            Supplier<Integer> random = () -> (int) (Math.random() * 100);
            Consumer<Integer> printRandom = a -> System.out.println("Numero aleatorio: " + a);
            for (int i = 0; i < 5; i++) {
                randomNumbers.add(random.get());
                printRandom.accept(randomNumbers.get(i));
            }
            System.out.println("********");

            // * Lista de cadenas
            ArrayList<String> strings = new ArrayList<>();
            strings.add("HOLA");
            strings.add("MUNDO");
            strings.add("JAVA");

            // * Usando UnaryOperator para converitr a minusculas
            UnaryOperator<String> toLowerCase = string -> string.toLowerCase();
            Consumer<String> printString = a -> System.out.println("Cadena: " + a);
            strings.forEach(a -> printString.accept(toLowerCase.apply(a)));
    }
}


