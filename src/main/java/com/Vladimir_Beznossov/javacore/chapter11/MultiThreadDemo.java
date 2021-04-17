package main.java.com.Vladimir_Beznossov.javacore.chapter11;
// Создать несколько потоков исполнения

class NewThread3 implements Runnable {
    String name;
    Thread t;

    NewThread3(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + " : " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершен");
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewThread3("Один");
        new NewThread3("Два");
        new NewThread3("Три");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Главный поток преован");
        }
        System.out.println("Главный поток завершен");
    }
}
