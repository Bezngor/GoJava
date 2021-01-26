package main.java.com.Vladimir_Beznossov.javacore.chapter18;

//Преобразовать списочный массив ArrayList в обыный массив

import java.util.ArrayList;

public class ArrayListToArray {
    public static void main(String[] args) {
        // создать списочный массив
        ArrayList<Integer> al = new ArrayList<>();

        // ввести элементы в списочный массив
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);

        System.out.println("Содержимое списочного массива al : " + al);

        // получить обычный массив
        Integer[] ia = new Integer[al.size()];
        ia = al.toArray(ia);

        int sum = 0;

        // сумировать элементы массива
        for (int i : ia) sum += i;

        System.out.println("Сумма : " + sum);
    }
}
