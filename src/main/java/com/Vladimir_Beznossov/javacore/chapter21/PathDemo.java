package main.java.com.Vladimir_Beznossov.javacore.chapter21;

// Получить сведения о пути к файлу и самом файле

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class PathDemo {
    public static void main(String[] args) {
        Path filepath = Paths.get("\\Users\\User\\IdeaProjects\\GoJava\\src\\practice\\TEST.txt");

        System.out.println("Имя файла: " + filepath.getName(6));
        System.out.println("Путь к файлу: " + filepath);
        System.out.println("Абсолютный путь к файлу: " + filepath.toAbsolutePath());
        System.out.println("Родительский каталог: " + filepath.getParent());

        if (Files.exists(filepath))
            System.out.println("Файл существует");
        else System.out.println("Файл не существует");

        try {
            if (Files.isHidden(filepath))
                System.out.println("Файл скрыт");
            else System.out.println("Файл не скрыт");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }

        Files.isWritable(filepath);
        System.out.println("Файл доступен для записи");

        Files.isReadable(filepath);
        System.out.println("Файл доступен для чтения");

        try {
            BasicFileAttributes attributes = Files.readAttributes(filepath, BasicFileAttributes.class);
            if (attributes.isDirectory())
                System.out.println("Это каталог");
            else System.out.println("Это не каталог");
            if (attributes.isRegularFile())
                System.out.println("Это обычный файл");
            else System.out.println("Это не обычный файл");
            if (attributes.isSymbolicLink())
                System.out.println("Это символическая ссылка");
            else System.out.println("Это не символическая ссылка");
            System.out.println("Время последней модификации файла: " + attributes.lastModifiedTime());
            System.out.println("Размер файла: " + attributes.size() + " байтов");
        } catch (IOException e) {
            System.out.println("Ошибка чтения атрибутов");
        }
    }
}
