package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pool {
    public void poolExecutorService(){

        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 7 ; i++) {
            int finalI = i;
            Runnable task1 = ()-> System.out.println("Ejecutando tarea  " + finalI + " " +Thread.currentThread().getName());
            pool.submit(task1);
        }
       pool.shutdown();

       //ExecutorService pool2 = Executors.newFixedThreadPool(3);

       //Runnable task1 = ()-> System.out.println("Ejecutando tarea 1 " +Thread.currentThread().getName());
       //Runnable task2 = ()-> System.out.println("Ejecutando tarea 2 " +Thread.currentThread().getName());
       //Runnable task3 = ()-> System.out.println("Ejecutando tarea 3 " +Thread.currentThread().getName());
       //Runnable task4 = ()-> System.out.println("Ejecutando tarea 4 " +Thread.currentThread().getName());
       //Runnable task5 = ()-> System.out.println("Ejecutando tarea 5 " +Thread.currentThread().getName());
       //Runnable task6 = ()-> System.out.println("Ejecutando tarea 6" + Thread.currentThread().getName());


       //pool2.submit(task1);
       //pool2.submit(task2);
       //pool2.submit(task3);
       //pool2.submit(task4);
       //pool2.submit(task5);
       //pool2.submit(task6);

       //pool2.shutdown();

    }
}
