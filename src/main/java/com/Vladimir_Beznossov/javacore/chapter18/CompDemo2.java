package main.java.com.Vladimir_Beznossov.javacore.chapter18;
// Использовать лямбда-выражение для создания компаратора с обратным упорядочением

import java.util.TreeSet;

public class CompDemo2 {
    public static void main(String[] args) {
        // передать комаратор с обратны упорядочением древовидному множеству типа TreeSet
        TreeSet<String> ts = new TreeSet<>((aStr, bStr) -> bStr.compareTo(aStr));

        // ввести элементы в древовидное множество
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("F");
        ts.add("E");
        ts.add("D");

        // вывести элементы из древовидного множества
        for (String element : ts)
            System.out.println(element + " ");
        System.out.println();
    }
}
