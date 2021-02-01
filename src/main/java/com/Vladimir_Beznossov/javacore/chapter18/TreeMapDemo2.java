package main.java.com.Vladimir_Beznossov.javacore.chapter18;
// Использовать компаратор для сортировки счетов по фамилиям вкладчиков

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// сравнить последние слова в обеих символьных строках
class TComp implements Comparator<String> {

    @Override
    public int compare(String aStr, String bStr) {
        int i, j, k;

        // найти индекс символа, с которого начинается фамилия
        i = aStr.lastIndexOf(" ");
        j = bStr.lastIndexOf(" ");
        k = aStr.substring(i).compareTo(bStr.substring(j));
        if (k == 0)     // Фамилии совпадают, проверить имя и фамилию полностью
            return aStr.compareTo(bStr);
        else return k;
    }
    // переопределять метод equals() не требуется
}

public class TreeMapDemo2 {
    public static void main(String[] args) {
        // создать древовидное отображение
        TreeMap<String, Double> tm = new TreeMap<>(new TComp());

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
