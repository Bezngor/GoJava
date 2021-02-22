package main.java.com.Vladimir_Beznossov.javacore.chapter20;

// Просмотреть каталог .pdf файлов

import java.io.File;
import java.io.FilenameFilter;

public class DirListOnly {
    public static void main(String[] args) {
        String dirName = "C:\\Users\\User\\Dropbox\\Documentos\\Papeles";
        File file = new File(dirName);
        FilenameFilter only = new OnlyExt("pdf");
        String[] s = file.list(only);

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
