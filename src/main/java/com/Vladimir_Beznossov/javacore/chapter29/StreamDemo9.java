package main.java.com.Vladimir_Beznossov.javacore.chapter29;

// Применить итератор-разделитель в потке данных

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo9 {
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

        // while (splitItr.tryAdvance(System.out::println));    //  перебор элементов
        splitItr.forEachRemaining(System.out::println);         // действие над всеми элементами сразу
    }
}
