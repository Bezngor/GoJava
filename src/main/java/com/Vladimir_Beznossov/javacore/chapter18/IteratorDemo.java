package main.java.com.Vladimir_Beznossov.javacore.chapter18;

// Продемонстрировать применение итераторов

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args) {
        // создать списочный массив
        ArrayList<String> al = new ArrayList<>();

        // ввести элементы в списочный массив
        al.add("C");
        al.add("A");
        al.add("B");
        al.add("D");
        al.add("E");
        al.add("F");

        // использовать итераторы для вывода содержмого списочного массива al
        System.out.print("Исходное содержмое списочного массива al: ");
        Iterator<String> itr = al.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();

        // видоизменить перебираеме объекты
        ListIterator<String> litr = al.listIterator();
        while (litr.hasNext()) {
            String element = litr.next();
            litr.set(element + "+");
        }

        System.out.print("Измененное содержмое списочного массива al: ");
        itr = al.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();

        // а теперь отобразить список в обратном порядке
        System.out.print("Измененный в обратном порядке список: ");
        while (litr.hasPrevious()) {
            String element = litr.previous();
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
