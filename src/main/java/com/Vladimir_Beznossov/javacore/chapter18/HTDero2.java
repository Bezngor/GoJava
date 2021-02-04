package main.java.com.Vladimir_Beznossov.javacore.chapter18;

// Приенить итераторы вместе с классом Hashtable

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HTDero2 {
    public static void main(String[] args) {
        Hashtable<String, Double> balance = new Hashtable<>();

        String str;
        double bal;

        balance.put("Джон Доу", 3434.34);
        balance.put("Тoм Смит", 123.22);
        balance.put("Джейн Бейкер", 1378.00);
        balance.put("Тод Холл", 99.22);
        balance.put("Ральф Смит", -19.08);

        // Вывести все счета в хеш-таблице. Сначала получить
        // представление всех ключей в виде множества
        Set<String> set = balance.keySet();

        // получить итератор
        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            str = itr.next();
            System.out.println(str + ": " + balance.get(str));
        }
        System.out.println();

        // внести 1000 на счет Джона Доу
        bal = balance.get("Джон Доу");
        balance.put("Джон Доу", bal + 1000);
        System.out.println("Новый остаток на счету Джона Доу: " + balance.get("Джон Доу"));
    }
}
