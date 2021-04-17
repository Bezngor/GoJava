package main.java.com.Vladimir_Beznossov.javacore.chapter28;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new LockThread(lock, "A");
        new LockThread(lock, "B");
    }
}

// Общий ресурс
class Shared2 {
    static int count = 0;
}

// Поток исполнения
class LockThread implements Runnable {
    String name;
    ReentrantLock lock;

    LockThread(ReentrantLock lock, String name) {
        this.lock = lock;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Запуск потока " + name);

        try {
            // Сначала заблокировать счетчик
            System.out.println("Поток " + name + " ожидает блокировки счетчика.");
            lock.lock();
            System.out.println("Поток " + name + " блокирует счетчик.");
            Shared2.count++;
            System.out.println("Поток " + name + ": " + Shared2.count);
            // а теперь переключение контекста, если это возможно
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        } finally {
            // Снять блокировку
            System.out.println("Поток " + name + " разблокирует счетчик.");
            lock.unlock();
        }
    }
}