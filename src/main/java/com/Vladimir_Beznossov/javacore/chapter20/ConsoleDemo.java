package main.java.com.Vladimir_Beznossov.javacore.chapter20;

import java.io.Console;

public class ConsoleDemo {
    public static void main(String[] args) {
        String str;
        Console con;

        // Получить ссылку на консоль
        con = System.console();

        // Выйти из программы, если консоль недоступна
        if (con == null) return;

        // Прочитать строку и вывести ее
        str = con.readLine("Введите строку: ");
        con.printf("Введенная вами строка: %s", str);
    }
}
