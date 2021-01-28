package main.java.com.Vladimir_Beznossov.javacore.chapter18;

// Простой пример обработки списка почтовых адресов

import javax.swing.*;
import java.util.LinkedList;

class Address {
    private String name;
    private String street;
    private String city;
    private String state;
    private String code;

    Address(String name, String street, String city, String state, String code) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.code = code;
    }

    @Override
    public String toString() {
        return name + "\n" + street + "\n" +
                city + " " + state + " " + code;
    }
}

public class MailList {
    public static void main(String[] args) {
        LinkedList<Address> ml = new LinkedList<>();
        ml.add(new Address("J.W.West" , "11 Oak Ave" ,"Urbana" , "IL" , "б1801"));
        ml.add(new Address("Ralph Baker" , "1142 Maple Lane", "Mahomet" , "IL" , "61853"));
        ml.add(new Address("Tom Carlton" , "867 Elm St", "Champaign" , "IL" , "61820"));

        // вывести список почтовых адресов
        for (Address element : ml)
            System.out.println(element + "\n");

        System.out.println();
    }
}
