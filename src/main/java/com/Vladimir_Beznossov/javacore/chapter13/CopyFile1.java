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

public class CopyFile1 {
    public static void main(String[] args) throws IOException {
        int i;
        FileInputStream fis = null;
        FileOutputStream fos = null;

        // сначала убедиться, что указаны имена обоих файлов
        if (args.length != 2) {
            System.out.println("Использование: CopyFile откуда куда");
            return;
        }

        // копировать файл
        try {
            // попытаться открыть файлы
            fis = new FileInputStream(args[0]);
            fos = new FileOutputStream(args[1]);

            do {
                i = fis.read();
                if (i != -1) fos.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
        finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e2) {
                System.out.println("Ошибка закрытия файла ввода.");
            }
            try {
                if (fos != null) fos.close();
            } catch (IOException e2) {
                System.out.println("Ошибка закрытия файла вывода.");
            }
        }
    }
}
