package main.java.com.Vladimir_Beznossov.javacore.chapter18;

// Продемонстрировать применение класса LinkedHashSet

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        // создать связное хеш-множество
        LinkedHashSet<String> hs = new LinkedHashSet<>();

        // ввести элементы в хеш-множество
        hs.add("Бета");
        hs.add("Альфа");
        hs.add("Эта");
        hs.add("Гамма");
        hs.add("Эпсилон");
        hs.add("Омега");

        System.out.println(hs);
    }
}
