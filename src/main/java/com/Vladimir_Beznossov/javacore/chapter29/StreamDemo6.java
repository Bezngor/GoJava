package main.java.com.Vladimir_Beznossov.javacore.chapter29;

// Отобразить поток данных типа Stream на поток данных типа IntStream

import java.util.ArrayList;
import java.util.stream.IntStream;

public class StreamDemo6 {
    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>();
        myList.add(7.2);
        myList.add(18.7);
        myList.add(10.9);
        myList.add(24.3);
        myList.add(17.5);
        myList.add(5.0);

        System.out.println("Исходные значения из списка myList: ");
        myList.stream().forEach(a -> System.out.print(a + " "));
        System.out.println();

        // отобразить максимально допустимый предел каждого значения из списка myList
        // на поток данных типа IntStream
        IntStream cStrm = myList.stream().mapToInt(a -> (int) Math.ceil(a));

        System.out.println("Максимально допустимые пределы значений из списка myList: ");
        cStrm.forEach(value -> System.out.print(value + " "));
    }
}
