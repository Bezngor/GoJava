package main.java.com.Vladimir_Beznossov.javacore.chapter29;

// Отобразить один поток данных на другой

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDemo4 {
    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>();
        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(17.0);
        myList.add(5.0);

        // отобразить квадратные корни элементов из списка на новый поток данных
        Stream<Double> sqrtRootStrm = myList.stream().map(a -> Math.sqrt(a));

        // получить произведение квадратных корней
        Double productOfSqrRoots = sqrtRootStrm.reduce(1.0, (a,b) -> a*b);

        System.out.println("Произведение квадратных корней: " + productOfSqrRoots);
    }
}
