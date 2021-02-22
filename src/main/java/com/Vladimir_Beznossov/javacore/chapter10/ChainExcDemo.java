package main.java.com.Vladimir_Beznossov.javacore.chapter10;

// Продемонстрировать цепочки исключений

public class ChainExcDemo {
    static void demproc() {

        // Создать исключение
        NullPointerException e = new NullPointerException("верхний уровень");

        // Добавить причину исключения
        e.initCause(new ArithmeticException("причина"));

        throw e;
    }

    public static void main(String[] args) {
        try {
            demproc();
        } catch (NullPointerException e) {
            // Вывести исключения верхнего уровня
            System.out.println("Перехвачено исключение: " + e);

            // Вывести исключение, послужившее причиной исключения верхнего уровня
            System.out.println("Первопричина: " + e.getCause());
        }
    }
}
