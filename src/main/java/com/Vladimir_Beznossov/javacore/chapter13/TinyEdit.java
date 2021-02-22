package main.java.com.Vladimir_Beznossov.javacore.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TinyEdit {
    public static void main(String[] args) throws IOException {
        String[] str = new String[100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите строки текста.");
        System.out.println("Введите 'стоп' для завершения.");
            for (int i = 0; i < 100; i++) {
                str[i] = br.readLine();
                if(str[i].equals("стоп")) break;
            }

        for (int i = 0; i < 100; i++) {
            if (str[i].equals("стоп")) break;
            System.out.println(str[i]);
        }
    }
}
