package main.java.com.Vladimir_Beznossov.javacore.chapter18;

// Продемонстрировать простое применение интерфейса Spliterator

import java.util.ArrayList;
import java.util.Spliterator;

public class SpliteratorDemo {
    public static void main(String[] args) {
        // создасть списочный массив числовых значений типа double
        ArrayList<Double> vals = new ArrayList<>();

        // ввести значения в списочный массив
        vals.add(1.0);
        vals.add(2.0);
        vals.add(3.0);
        vals.add(4.0);
        vals.add(5.0);

        // вызвать метод tryAdvance для вывода содержимого списочного массива vals
        System.out.print("Содержимого списочного массива vals:\n");
        Spliterator<Double> splititr = vals.spliterator();
        while (splititr.tryAdvance((n) -> System.out.println(n)));
        System.out.println();

        // создать новый списочный массив, содержащий квадратный корни числовых значений
        // из списочного массива vals
        splititr = vals.spliterator();
        ArrayList<Double> sqrs = new ArrayList<>();
        while (splititr.tryAdvance((n) -> sqrs.add(Math.sqrt(n))));

        // вызвать метод forEachRemaining() для вывода содержимого списочного массива sqrs
        System.out.print("Содержимого списочного массива sqrs:\n");
        splititr = sqrs.spliterator();
        splititr.forEachRemaining((n) -> System.out.println(n));
        System.out.println();
    }
}
