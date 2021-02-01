package main.java.com.Vladimir_Beznossov.javacore.chapter18;
//Использовать специальный компаратор

import java.util.Comparator;
import java.util.TreeSet;

// Компаратор для сравнения символьных строк в обратном порядке
class MyComp implements Comparator<String> {

    @Override
    public int compare(String a, String b) {
        String aStr, bStr;
        aStr = a;
        bStr = b;
        // выполнить сравнение в обратном порядке
        return bStr.compareTo(aStr);
    }
    // переопределять метод equals() не требуется
}

public class CompDemo {
    public static void main(String[] args) {
        // создать древовидное множество типа TreeSet
        TreeSet<String> ts = new TreeSet<>(new MyComp());
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
