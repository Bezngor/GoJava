package main.java.com.Vladimir_Beznossov.javacore.chapter18;

// Применение цикла for в стиле for each для перебора элементов коллекции

import java.util.ArrayList;

public class ForEachDemo {
    public static void main(String[] args) {
        // создать списочный массив для целых чисел
        ArrayList<Integer> vals = new ArrayList<>();

        // ввести числовые значения в списочный массив
        vals.add(1);
        vals.add(2);
        vals.add(3);
        vals.add(4);
        vals.add(5);

        // организовать цикл для вывода числовых значений
        System.out.print("Исходное содержимое списочного массива vals: ");
        for (int v : vals) {
            System.out.print(v + " ");
        }
        System.out.println();

        // суммировать числовые значения в цикле for
        int sum = 0;
        for (int v : vals) {
            sum += v;
        }
        System.out.print("Сумма числовых значений: " + sum);
    }
}
