package main.java.com.Vladimir_Beznossov.javacore.chapter18;
// Использовать метод thenComparinq() для сортировки счетов
// вкладчиков сначала по фамлии, а затем по имени

import java.util.*;

// Компаратор, сравнивающий фамлии вкладчиков
class CompLastNames implements Comparator<String> {

    @Override
    public int compare(String aStr, String bStr) {
        int i, j;
        i = aStr.lastIndexOf(" ");
        j = bStr.lastIndexOf(" ");
        return aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
    }
}

// отсортировать счета вкладчиков по Ф.И.О., если фамилии одинаковы
class CompThenByFirstName implements Comparator<String> {

    @Override
    public int compare(String aStr, String bStr) {
        //int i, j;
        return aStr.compareToIgnoreCase(bStr);
    }
}

public class TreeMapDemo2A {
    public static void main(String[] args) {
        // использовать метод thenComparinq() для создания
        // компаратора, сравнивающего сначала фамилии, а затем
        // Ф.И.О. вкладчиков, если фамлиии одинаковы
        CompLastNames compLN = new CompLastNames();
        Comparator<String> compLastThenFirst = compLN.thenComparing(new CompThenByFirstName());

        // создать древовидное отображение
        TreeMap<String, Double> tm = new TreeMap<>(compLastThenFirst);

        // ввести элементы в древовидное отображени
        tm.put("Джон Доу", 3434.34);
        tm.put("Тoм Смит", 123.22);
        tm.put("Джейн Бейкер", 1378.00);
        tm.put("Тод Холл", 99.22);
        tm.put("Ральф Смит", -19.08);

        //  получить множество элементов
        Set<Map.Entry<String, Double>> set = tm.entrySet();

        // вывести множество элементовэлементов
        for (Map.Entry<String, Double> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        // внести 1000 на счет Джона Доу
        Double balance = tm.get("Джон Доу");
        tm.put("Джон Доу", balance + 1000);
        System.out.println("Новый остаток на счету Джона Доу: " + tm.get("Джон Доу"));
    }
}
