package main.java.com.Vladimir_Beznossov.javacore.chapter10;

// Продемонстрировать применение оператора finally

public class FinallyDemo {
    // Сгенерировать исключение в методе
    static void procA() {
        try {
            System.out.println("В теле метода procA");
            throw new RuntimeException("демонстрация");
        } finally {
            System.out.println("Блок опрератора finally в методе procA");
        }
    }

    // Возвратить управление из блока оператора try
    static void procB() {
        try {
            System.out.println("В теле оператора procB");
            return;
        } finally {
            System.out.println("Блок опрератора finally в методе procB");
        }
    }

    // Выполнить блок try, как обычно
    static void procC() {
        try {
            System.out.println("В теле оператора procC");
        } finally {
            System.out.println("Блок опрератора finally в методе procC");
        }
    }

    public static void main(String[] args) {
        try {
            procA();
        } catch (RuntimeException e) {
            System.out.println("Исключение перехвачено");
        }

        procB();
        procC();
    }
}
