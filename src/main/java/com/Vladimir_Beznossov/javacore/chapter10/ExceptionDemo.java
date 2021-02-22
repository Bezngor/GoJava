package main.java.com.Vladimir_Beznossov.javacore.chapter10;

// В этой программе создается специальный тип исключений

class MyException extends Exception {
    int detail;

    MyException(int a) {
        detail = a;
    }

    public String toString() {
        return "MyException [" + detail + "]";
    }
}

public class ExceptionDemo {
    static void compute(int a) throws MyException {
        System.out.println("Вызван метод compute(" + a + ")");
        if (a > 10) throw new MyException(a);

        System.out.println("Нормальное завершение");
    }

    public static void main(String[] args) {
        try {
            compute(1);
            compute(20);
        } catch (MyException e) {
            System.out.println("Перехвачено исключение: " + e);
        }
    }
}
