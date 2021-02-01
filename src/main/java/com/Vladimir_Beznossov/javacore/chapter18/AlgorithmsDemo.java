package main.java.com.Vladimir_Beznossov.javacore.chapter18;
// Продемонстрировать применение различных алгоритмов коллекций

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class AlgorithmsDemo {
    public static void main(String[] args) {
        // создать неинициализированны связный список
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(-8);
        ll.add(20);
        ll.add(8);
        ll.add(-20);

        // вывести исходый список
        System.out.println("Исходный список: ");
        for (Integer i : ll)
            System.out.print(i + " ");
        System.out.println();

        // создать компаратор с обратным упорядочением
        Comparator<Integer> r = Collections.reverseOrder();

        // отсортировать список с помощью этого компаратора
        // Collections.reverse(ll);
        Collections.sort(ll, r);

        System.out.println("Список отсортирован в обратном порядке: ");
        for (Integer i : ll)
            System.out.print(i + " ");
        System.out.println();

        // перетасовать список
        Collections.shuffle(ll);

        // вывести перетасованный список
        System.out.println("Список перетасован: ");
        for (Integer i : ll)
            System.out.print(i + " ");
        System.out.println();
        System.out.println("Минимум: " + Collections.min(ll));
        System.out.println("Максимум: " + Collections.max(ll));
    }
}
