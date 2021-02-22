package main.java.com.Vladimir_Beznossov.javacore.chapter20;

import java.io.*;

public class DataIODemo {
    public static void main(String[] args) {
        // Сначала вывести данные в файл
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("test.dat"));) {
            dout.writeDouble(98.66);
            dout.writeBoolean(true);
            dout.writeInt(1000);
        } catch (FileNotFoundException e) {
            System.out.println("Нельзя открыть файл вывода");
        } catch (IOException e ) {
            System.out.println("Ошибка ввода-вывода");
        }

        // а теперь вывести данные из файла
        try (DataInputStream din = new DataInputStream(new FileInputStream("test.dat"))) {
            double d = din.readDouble();
            boolean b = din.readBoolean();
            int i = din.readInt();

            System.out.println("Получаемые значения: " + d + " " + b + " " + i);
        } catch (FileNotFoundException e) {
            System.out.println("Нельзя открыть файл вывода");
        } catch (IOException e ) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
