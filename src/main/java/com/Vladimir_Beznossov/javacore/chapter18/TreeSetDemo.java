package main.java.com.Vladimir_Beznossov.javacore.chapter18;

// Продемонстрировать применение класса TreeSet

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        // создать древовидное множество типа TreeSet
        TreeSet<String> ts = new TreeSet<>();

        // ввести элементы в древовидное можество типа TreeSet
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        System.out.println(ts);
        System.out.println(ts.subSet("C", "F"));
    }
}
