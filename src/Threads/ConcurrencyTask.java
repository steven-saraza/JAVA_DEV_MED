package Threads;

import java.util.Scanner;
import java.util.concurrent.*;

public class ConcurrencyTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int a;
        int b;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numeros ingrese el primer numero");
        a = scanner.nextInt();
        System.out.println("Ingrese segundo numero");
        b = scanner.nextInt();
        return a * b;

    }

    public void callCall(int number) throws Exception {
        ConcurrencyTask concurrencyTask = new ConcurrencyTask();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<Integer> returner = pool.submit(concurrencyTask);
        pool.shutdown();
        try{
            int value = returner.get();
            System.out.println("La multiplicacion " + value);
        }catch (ExecutionException | InterruptedException e){
            System.out.println(e);
        }
    }
}
