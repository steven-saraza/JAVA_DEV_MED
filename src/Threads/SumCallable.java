package Threads;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class SumCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Numeros ingrese el primer numero");
        int a = scanner.nextInt();
        System.out.println("Ingrese segundo numero");
        int b = scanner.nextInt();
        return a +b;
    }
}
