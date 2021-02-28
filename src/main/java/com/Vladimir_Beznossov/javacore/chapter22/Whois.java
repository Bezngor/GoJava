package main.java.com.Vladimir_Beznossov.javacore.chapter22;

// Продемонстрировать обращение с сокетами

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Whois {
    public static void main(String[] args) {
        int c;

        // создать сокетное соединение с сайтом internic.net через порт 43
        try (Socket s = new Socket("whois.internic.net", 43);)
        {
            // получить потоки ввода-вывода
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            // сформировать строку запроса
            String str = (args.length == 0 ? "MHProfessional.com" : args[0]) + "\n";

            // преобразовать строку в байты
            byte[] buf = str.getBytes();

            // послать запрос
            out.write(buf);

            // прочитать ответ и вывести его на экран
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
