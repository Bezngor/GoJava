package main.java.com.Vladimir_Beznossov.javacore.chapter10;

public class ThrowDemo {
    static void demoproc() {
        try {
            throw new NullPointerException("Демонстрация");
        } catch (NullPointerException e) {
            System.out.println("Исключение перехвачено в теле метода demproc().");
            throw e; // повторно сгенерировать исключение
        }
    }

    public static void main(String[] args) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            System.out.println("Повторный перехват: " + e);
        }
    }
}
