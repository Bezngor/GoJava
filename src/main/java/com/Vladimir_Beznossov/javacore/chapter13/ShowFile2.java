package main.java.com.Vladimir_Beznossov.javacore.chapter13;

/*
Отображение содержимого текстового файла. Чтобы воспользоваться этой програмой, укажте
имя файла, который требуется просмотреть.
Например , чтобы просмотреть файл TEST.TXТ, введите в командной строке следующую команду:
java ShowFile ТЕSТ.ТXТ

В этом варианте програмы код, открывающий и получающий доступ к файлу, закючен в один блок
оператора try. Файл закрывается в блоке оператора finally.
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile2 {
    public static void main(String[] args) {
        int i;
        FileInputStream fis = null;

        // Сначала убедиться, что имя файла указано
        if (args.length != 1) {
            System.out.println("Использование файла: ShowFile имя_файла");
            return;
        }

        // В следующем коде сначала открывается файл, а затем из него читаются
        // символы до тех пор, пока не встретится признак конца файла.
        try {
            fis = new FileInputStream(args[0]);
            do {
                i = fis.read();
                if (i != -1) System.out.println((char) i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }

        finally {
            // закрыть файл в любом случае
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файла.");
            }
        }
    }
}
