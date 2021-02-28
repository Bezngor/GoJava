package main.java.com.Vladimir_Beznossov.javacore.chapter22;

// Продемонстрировать применение класса HttpURLConnection

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpURLDemo {
    public static void main(String[] args) throws Exception {
        URL hp = new URL("http://www.google.com");
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();

        // вывести метод запроса
        System.out.println("Метод запроса: " + hpCon.getRequestMethod());

        // вывести код ответа
        System.out.println("Код ответа: " + hpCon.getResponseCode());

        // ввести ответное сообщение
        System.out.println("Ответное сообщение: " + hpCon.getResponseMessage());

        // получить список полей и множество ключей из заголовка
        Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
        Set<String> hdrFields = hdrMap.keySet();
        System.out.println("\nДалее следует заголовок:");

        for (String k : hdrFields) {
            System.out.println("Ключ: " + k + "Значение: " + hdrMap.get(k));
        }
    }
}
