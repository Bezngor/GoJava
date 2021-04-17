package main.java.com.Vladimir_Beznossov.javacore.chapter28;
// Пример применения класса Exchanger

import java.util.concurrent.Exchanger;

public class ExgrDemo {
    public static void main(String[] args) {
        Exchanger<String> exgr = new Exchanger<>();
        new UseString(exgr);
        new MakeString(exgr);
    }
}

// Поток, формирующий символьную строку
class MakeString implements Runnable {
    Exchanger<String> ex;
    String str;

    MakeString(Exchanger<String> ex) {
        this.ex = ex;
        str = "";
        new Thread(this).start();
    }

    @Override
    public void run() {
        char ch = 'A';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                str += (char) ch++;
            }

            try {
                str = ex.exchange(str);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class UseString implements Runnable {
    Exchanger<String> ex;
    String str;

    UseString(Exchanger<String> ex) {
        this.ex = ex;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = ex.exchange(new String());
                System.out.println("Получено: " + str);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
