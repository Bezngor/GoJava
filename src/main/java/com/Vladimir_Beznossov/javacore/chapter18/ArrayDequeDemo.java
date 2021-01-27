package main.java.com.Vladimir_Beznossov.javacore.chapter18;

// Продемонстрировать применения класса ArrayDequeue для организации стека

import java.util.ArrayDeque;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        // создать двухстороннюю очередь
        ArrayDeque<String> adq = new ArrayDeque<>();

        // использовать класс ArrayDeque для организации стека
        adq.push("A");
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");
        adq.push("C");

        System.out.print("Извлечение из стека: ");

        while (adq.peek() != null)
            System.out.print(adq.pop() + " ");
    }
}
