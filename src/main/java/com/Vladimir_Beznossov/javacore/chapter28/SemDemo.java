package main.java.com.Vladimir_Beznossov.javacore.chapter28;
// Простой пример применения семафора

import java.util.concurrent.Semaphore;

public class SemDemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        new IncThread(sem, "A");
        new DecThread(sem, "B");
    }
}

// Общий ресурс
class Shared {
    static int count = 0;
}

// Поток исполнения, увеличивающий значение счетчика на единицу
class IncThread implements Runnable {
    String name;
    Semaphore sem;

    IncThread(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Запуск потока " + name);
        try {
            // Сначала получить разрешение
            System.out.println("Поток " + name + " ожидает разрешения");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешение");

            // А теперь получить доступ к общему ресурсу
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                // разрешить, если возможно, переключение контекста
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // Освободить разрешение
        System.out.println("Поток " + name + " освобождает разрешение");
        sem.release();
    }
}

// Поток исполнения, уменьшающий значение счетчика на единицу
class DecThread implements Runnable {
    String name;
    Semaphore sem;

    DecThread(Semaphore sem, String name) {
        this.name = name;
        this.sem = sem;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Запуск потока " + name);
        try {
            System.out.println("Поток " + name + " ожидает разрешения");
            sem.acquire();
            System.out.println("Поток " + name + " получает разрешение");

            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(10);
            }

        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Поток " + name + " освобождает разрешение");
        sem.release();
    }
}
