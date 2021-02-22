package main.java.com.Vladimir_Beznossov.javacore.chapter15;

// Применить обощенный функциональный интерфейс с разнотипными лямбда-выражениями

// Обощенный функциональный интерфейс
interface SomeFunc<T> {
    T func(T t);
}

public class GenericFunctionalinterfaceDemo {
    public static void main(String[] args) {
        // Использовать строковый вариант интерфейса SomeFunc
        SomeFunc<String> revers = (str) -> {
            String result = "";
            for (int i = str.length()-1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        System.out.println("Лямбда обращается на " + revers.func("Лямбда"));
        System.out.println("Выражение обращается на " + revers.func("Выражение"));

        // А теперь использовать целочисленный вариант интерфейса SomeFunc
        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };

        System.out.println("Факториал числа 3 равен " + factorial.func(3));
        System.out.println("Факториал числа 5 равен " + factorial.func(5));
    }

}
