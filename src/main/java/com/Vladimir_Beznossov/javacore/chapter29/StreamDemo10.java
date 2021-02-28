package main.java.com.Vladimir_Beznossov.javacore.chapter29;

// Продемонстрировать применение метода trySplit()

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo10 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Alpha");
        myList.add("Beta");
        myList.add("Gamma");
        myList.add("Delta");
        myList.add("Omega");
        myList.add("Zeta");

        Stream<String> myStream = myList.stream();
        Spliterator<String> splitItr = myList.spliterator();

        // разделить итератор splitItr
        Spliterator<String> splitItr2 = splitItr.trySplit();

        // использовать сначала итератор splitItr2, если нельзя разделить итератор splitItr
        if (splitItr2 != null) {
            System.out.println("Результат, выводимый итератором splitItr2: ");
            splitItr2.forEachRemaining(System.out::println);
        }
        System.out.println();

        // а теперь воспользоваться итератором splitItr
        System.out.println("Результат, выводимый итератором splitItr: ");
        splitItr.forEachRemaining(System.out::println);
    }
}
