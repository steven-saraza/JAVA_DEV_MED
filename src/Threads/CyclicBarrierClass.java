package Threads;

import java.util.concurrent.*;

public class CyclicBarrierClass {

    public void cyclicBarrierClass(){
        CyclicBarrier barrier = new CyclicBarrier(4);
        System.out.println("Numero de hilos para romper barrera  " + barrier.getParties());

        Callable<String> task1 = () -> {
            barrier.wait();
            System.out.println("Tarea1");
            Thread.sleep((int)(Math.random()*3000)+1000);
            return "Tarea 1 completad ";
        };

        Callable<String> task2 = () -> {
            barrier.wait();
            System.out.println("Tarea2");
            Thread.sleep((int)(Math.random()*3000)+1000);
            return "Tarea 2 completad ";
        };

        Callable<String> task3 = () -> {
            barrier.wait();
            System.out.println("Tarea2");
            Thread.sleep((int)(Math.random()*3000)+1000);
            return "Tarea 2 completad ";
        };

        Callable<String> task4 = () -> {
            barrier.wait();
            System.out.println("Tarea2");
            Thread.sleep((int)(Math.random()*3000)+1000);
            return "Tarea 2 completad ";
        };

        //Permite que no se quede esperando los hilos sino que avancen y se ejecuten
        ExecutorService pool = Executors.newFixedThreadPool(4);
        Future<String> value = pool.submit(task1);
        Future<String> value2 = pool.submit(task2);
        Future<String> value3 = pool.submit(task3);
        Future<String> value4 = pool.submit(task4);
        pool.shutdown();

        try {
            String return1 = value.get();
            String return2 = value2.get();
            String return3 = value3.get();
            String return4 = value4.get();
            System.out.println("Resultado: " + return1 + return2);
            barrier.reset();
            System.out.println("se reseteeo el barrier");

        }catch (ExecutionException|InterruptedException e){
            System.out.println(e);
        }


    }
}
