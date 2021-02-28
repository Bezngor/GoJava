package main.java.com.Vladimir_Beznossov.javacore.chapter29;

// Продемонстрировать несколько потоковых операций

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        System.out.println("Исходный список: " + myList);

        // Получить поток элементов списочного массива
        Stream<Integer> myStream = myList.stream();

        // Получить минимальное и максимальное значения
        Optional<Integer> minVal = myStream.min(Integer::compareTo);
        if (minVal.isPresent())
            System.out.println("Минимальное значение: " + minVal.get());

        // Непременно получить новый поток данных, поскольку предыдущий вызов метода min()
        // стал оконечной операцией, употребившей поток данных
        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compareTo);
        if (maxVal.isPresent())
            System.out.println("Максимальное значение: " + maxVal.get());

        // Отсортировать поток данных
        Stream<Integer> sortedStream = myList.stream().sorted();
        // Отобразить отсортированный поток
        System.out.print("Отсортированный поток: ");
        sortedStream.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Вывести только нечетные целочисленные значения
        Stream<Integer> oddVal = myList.stream().filter(n -> n%2 == 1);
        System.out.print("Нечетные значения: ");
        oddVal.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Вывести только те нечетные целочисленные значения, которые больше 5
        oddVal = myList.stream().filter(n -> n%2 == 1).filter(n -> n > 5);
        System.out.print("Нечетные значения больше 5: ");
        oddVal.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
