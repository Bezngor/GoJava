package main.java.com.Vladimir_Beznossov.javacore.chapter13;

/*
Копирование файла.
Чтобы воспользоваться этой програмой, укажите имена исходного и целевого файлов.
Например, чтобы скопировать файл FIRST.TXT в файл SECOND.ТXT,
введите в командной строке следующую команду:
java CopFile FIRST.TXT SECOND.ТXT
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile2 {
    public static void main(String[] args) throws IOException {
        int i;

        // сначала убедиться, что указаны имена обоих файлов
        if (args.length != 2) {
            System.out.println("Использование: CopyFile откуда куда");
            return;
        }

        // открыть два файла и управлять ними в операторе try
        try (FileInputStream fis = new FileInputStream(args[0]);
             FileOutputStream fos = new FileOutputStream(args[1]);
        ) {
            do {
                i = fis.read();
                if (i != -1) fos.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
