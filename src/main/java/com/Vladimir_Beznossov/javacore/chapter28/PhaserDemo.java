package main.java.com.Vladimir_Beznossov.javacore.chapter28;
// Применение класса Phaser

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phsr = new Phaser(1);
        int curPhase;

        System.out.println("Запуск потоков.");

        new MyThread3(phsr, "A");
        new MyThread3(phsr, "B");
        new MyThread3(phsr, "C");

        // Ожидать завершения всеми потоками исполнения 1-й фазы
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена.");

        // Ожидать завершения всеми потоками исполнения 1-й фазы
        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена.");

        curPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Фаза " + curPhase + " завершена.");

        // снять основной поток с регистрации
        phsr.arriveAndDeregister();

        if (phsr.isTerminated())
            System.out.println("Синхронизатор фаз завершен.");
    }
}

class MyThread3 implements Runnable {
    Phaser phsr;
    String name;

    MyThread3 (Phaser phsr, String name) {
        this.name = name;
        this.phsr = phsr;
        phsr.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Поток " + name + " начинает первую фазу.");
        phsr.arriveAndAwaitAdvance(); // известить о достижении фазы

        // Небольшая пуза, чтобы не нарушить порядок вывода.
        // Только для иллюстрации, но не обязательно для правильного функционирования
        // синхронизатора фаз.
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Поток " + name + " начинает вторую фазу.");
        phsr.arriveAndAwaitAdvance();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Поток " + name + " начинает третью фазу.");
        phsr.arriveAndDeregister();  // известить о достижении фазы и снять потоки с регистрации
    }
}
