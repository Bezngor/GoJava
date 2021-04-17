package main.java.com.Vladimir_Beznossov.javacore.chapter28;
// Расширить класс Phaser и переопределить метод onAdvance() таким образом,
// чтобы было выполнено только определенное количество фаз.

import java.util.concurrent.Phaser;

class MyPhaser extends Phaser {
    int numPhases;

    MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhases = phaseCount - 1;
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("Фаза " + phase + " завершена.\n");

        // Возвратить логическое true, если все фазы завершены
        if (phase == numPhases || registeredParties == 0) return true;
        // в противном случае возвратить false.
        else return false;
    }
}

public class PhaserDemo2 {
    public static void main(String[] args) {
        MyPhaser phsr = new MyPhaser(1,4);

        new MyThread4(phsr, "A");
        new MyThread4(phsr, "B");
        new MyThread4(phsr, "C");

        while (!phsr.isTerminated()) {
            phsr.arriveAndAwaitAdvance();
        }

        System.out.println("Синхронизатор фаз завершен.");
    }
}

class MyThread4 implements Runnable {
    Phaser phsr;
    String name;

    MyThread4(Phaser phsr, String name) {
        this.phsr = phsr;
        this.name = name;
        phsr.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!phsr.isTerminated()) {
            System.out.println("Поток " + name + " начинает фазу " + phsr.getPhase());
            phsr.arriveAndAwaitAdvance();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
