package Threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("1 Interfaz Runnable\n");
        CountRunnable count = new CountRunnable();
        count.run();
        System.out.println("**************************\n");

        System.out.println("2 Pool Executor Service\n");
        Pool poolExecutorService = new Pool();
        poolExecutorService.poolExecutorService();
        System.out.println("**************************\n");

        System.out.println("3 Cyclic Barrier\n");
        CyclicBarrierClass cyclicBarrierClass = new CyclicBarrierClass();
        cyclicBarrierClass.cyclicBarrierClass();
        System.out.println("**************************\n");

        System.out.println("4 Buenas practicas manejo de hilos\n");
        ConcurrencyTask callCall = new ConcurrencyTask();
        callCall.callCall(5);
        System.out.println("**************************\n");

        System.out.println("5 Callable y Future\n");
        SumCallable sumCallable= new SumCallable();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<Integer> returner = pool.submit(sumCallable);
        pool.shutdown();
        try{
            int value = returner.get();
            System.out.println("La suma " + value);
        }catch (ExecutionException|InterruptedException e){
            System.out.println(e);
        }
        System.out.println("**************************\n");
    }
}
