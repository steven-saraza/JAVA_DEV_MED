package Threads;

public class CountRunnable implements Runnable{
    @Override
    public void run() {

        System.out.println("Inicio del contador" + Thread.currentThread().getName());
        int count = 0;
        for (int i = 0; i < 11 ; i++) {
            try {
                Thread.sleep(1500);
                System.out.println("Contador " + count);
                count += 1;
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
