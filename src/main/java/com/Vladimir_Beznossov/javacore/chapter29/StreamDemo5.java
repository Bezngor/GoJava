package main.java.com.Vladimir_Beznossov.javacore.chapter29;

// Применить метод map() для создания нового потока данных, содержащего только избранные элементы
// из исходного потока

import java.util.ArrayList;
import java.util.stream.Stream;

class PhoneNameEmail {
    String phone;
    String name;
    String email;

    PhoneNameEmail(String phone, String name, String email) {
        this.phone = phone;
        this.name = name;
        this.email = email;
    }
}

class PhoneName {
    String phone;
    String name;

    PhoneName(String phone, String name) {
        this.phone = phone;
        this.name = name;
    }
}

public class StreamDemo5 {
    public static void main(String[] args) {
        ArrayList<PhoneNameEmail> myList = new ArrayList<>();
        myList.add(new PhoneNameEmail("222 22-22", "Phill", "phill@mail.com"));
        myList.add(new PhoneNameEmail("333 33-33", "John", "john@mail.com"));
        myList.add(new PhoneNameEmail("444 44-44", "Mickey", "mickey@mail.com"));
        myList.add(new PhoneNameEmail("555 55-55", "Oliver", "oliver@mail.com"));

        System.out.println("Исходные элементы из списка: ");

        myList.stream().forEach(a -> {
            System.out.println(a.name + " " + a.phone + " " + a.email);
        });
        System.out.println();

        // отобразить на новый поток данных только имена и номера телефонов
        Stream<PhoneName> nameAndPhone = myList.stream().map(
                a -> new PhoneName(a.phone, a.name)
        );

        System.out.println("Список имен и номеров телефонов: ");
        nameAndPhone.forEach(a -> System.out.println(a.name + " " + a.phone));
    }

}
