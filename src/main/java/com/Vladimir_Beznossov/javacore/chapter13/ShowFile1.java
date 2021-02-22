package main.java.com.Vladimir_Beznossov.javacore.chapter13;

/*
Отображение содержимого текстового файла. Чтобы воспользоваться этой програмой, укажте
имя файла, который требуется просмотреть.
Например , чтобы просмотреть файл TEST.TXТ, введите в командной строке следующую команду:
java ShowFile ТЕSТ.ТXТ
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile1 {
    public static void main(String[] args) {
        int i;
        FileInputStream fis;

        // Сначала убедиться, что имя файла указано
        if (args.length != 1) {
            System.out.println("Использование файла: ShowFile имя_файла");
            return;
        }

        // Попытка открыть файл
        try {
            fis = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно открыть файл.");
            return;
        }

        // Теперь файл открыт и готов к чтению.
        // Далее из него читаются сиволы до тех пор,
        // пока не встретится признак конца файла.
        try {
            do {
                i = fis.read();
                if (i != -1) System.out.println((char) i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла.");
        }

        // Закрыть файл
        try {
            fis.close();
        } catch (IOException e) {
            System.out.println("Ошибка закрытия файла.");
        }
    }
}
