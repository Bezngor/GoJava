package main.java.com.Vladimir_Beznossov.javacore.chapter20;

import java.io.*;

class MyClass implements Serializable {
    String s;
    int i;
    double d;

    MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return "s= " + s + ", i=" + i + ", d=" + d;
    }
}

public class SerializationDemo {

    public static void main(String[] args) {
        // Произвести сериализацию объекта
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serial.txt"));)
        {
            MyClass object1 = new MyClass("Hello", -7, 123.456);
            System.out.println("object1: " + object1);
            oos.writeObject(object1);
        } catch (IOException e) {
            System.out.println("Исключение при сериализации: " + e);
        }

        // Произвести десериализацию объекта
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serial.txt")))
        {
            MyClass object2 = (MyClass) ois.readObject();
            System.out.println("object2: " + object2);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Исключение при десериализации: " + e);
            System.exit(0);
        }
    }
}
