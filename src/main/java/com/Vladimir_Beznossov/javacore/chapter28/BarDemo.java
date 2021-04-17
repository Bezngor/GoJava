package main.java.com.Vladimir_Beznossov.javacore.chapter28;
// Продемонстрировать использование класса CyclicBarrier

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cbar = new CyclicBarrier(3, new BarAction());

        System.out.println("Запуск потоков.");

        new MyThread2(cbar, "A");
        new MyThread2(cbar, "B");
        new MyThread2(cbar, "C");
        new MyThread2(cbar, "X");
        new MyThread2(cbar, "Y");
        new MyThread2(cbar, "Z");
    }
}

class MyThread2 implements Runnable {
    String name;
    CyclicBarrier cbar;

    MyThread2(CyclicBarrier cbar, String name) {
        this.name = name;
        this.cbar = cbar;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name);

        try {
            cbar.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        }
    }
}

class BarAction implements Runnable {

    @Override
    public void run() {
        System.out.println("Барьер достигнут!");
    }
}
