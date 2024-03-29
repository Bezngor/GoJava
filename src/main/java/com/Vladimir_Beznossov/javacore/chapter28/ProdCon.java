package main.java.com.Vladimir_Beznossov.javacore.chapter28;
// Реализация поставщика и потребителя, использующая семафоры для управления синхронизацией

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.Semaphore;

class Q {
    int n;

    // Начать с недоступного семафора потребителя
    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            System.out.println("Перехвачено исключение InterruptedException");
        }
        System.out.println("Получено: " + n);
        semProd.release();
    }

    void put(int n) {
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            System.out.println("Перехвачено исключение InterruptedException");
        }
        this.n = n;
        System.out.println("Отправлено: " + n);
        semCon.release();
    }
}

class Producer implements Runnable {
    Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) q.put(i);
    }
}

class Consumer implements Runnable {
    Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) q.get();
    }
}

public class ProdCon {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }

}
