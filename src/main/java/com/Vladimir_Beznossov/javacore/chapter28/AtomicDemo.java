package main.java.com.Vladimir_Beznossov.javacore.chapter28;
// Простой пример выполнения атомарных операций

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) {
        new AtomicThread("A");
        new AtomicThread("B");
        new AtomicThread("C");
    }
}

class Shared3 {
    static AtomicInteger ai = new AtomicInteger(0);
}

class AtomicThread implements Runnable {
    String name;

    AtomicThread(String name) {
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Запуск потока " + name);
        for (int i = 1; i <= 3; i++)
            System.out.println("Поток " + name + " получено: " + Shared3.ai.getAndSet(i));
    }
}