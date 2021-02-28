package main.java.com.Vladimir_Beznossov.javacore.chapter21;

// Вывести содержимое каталога

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirList {
    public static void main(String[] args) {
        String dirname = "\\Users\\User\\IdeaProjects\\GoJava";

        // Получить и обработать поток ввода каталога
        try (DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirname)))
        {
            System.out.println("Каталог " + dirname);
            for (Path entry : dirstrm) {
                BasicFileAttributes attributes = Files.readAttributes(entry, BasicFileAttributes.class);
                if (attributes.isDirectory())
                    System.out.print("<DIR> ");
                else
                    System.out.print("      ");
                System.out.println(entry.getName(4));
            }
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути");
        } catch (NotDirectoryException e) {
            System.out.println(dirname + " не является каталогом");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
