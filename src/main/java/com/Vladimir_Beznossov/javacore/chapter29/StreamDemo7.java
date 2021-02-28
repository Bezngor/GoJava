package main.java.com.Vladimir_Beznossov.javacore.chapter29;

// Использовать метод collect() для создания списка типа List и множества типа Set из потока данных

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PhoneNameEmail2 {
    String phone;
    String name;
    String email;

    PhoneNameEmail2(String phone, String name, String email) {
        this.phone = phone;
        this.name = name;
        this.email = email;
    }
}

class PhoneName2 {
    String phone;
    String name;

    PhoneName2(String phone, String name) {
        this.phone = phone;
        this.name = name;
    }
}

public class StreamDemo7 {
    public static void main(String[] args) {
        ArrayList<PhoneNameEmail2> myList = new ArrayList<>();
        myList.add(new PhoneNameEmail2("222 22-22", "Phill", "phill@mail.com"));
        myList.add(new PhoneNameEmail2("333 33-33", "John", "john@mail.com"));
        myList.add(new PhoneNameEmail2("444 44-44", "Mickey", "mickey@mail.com"));
        myList.add(new PhoneNameEmail2("555 55-55", "Oliver", "oliver@mail.com"));

        Stream<PhoneName2> nameAndPhone = myList.stream().map(a -> new PhoneName2(a.phone, a.name));

        // вызвать метод collect(), чтобы составить список типа List из имен и номеров
        List<PhoneName2> npList = nameAndPhone.collect(Collectors.toList());

        System.out.println("Имена и номера телефонов в списке типа List: ");
        for (PhoneName2 a : npList)
            System.out.println(a.name + " " + a.phone);
        System.out.println();

        // получить другое отображение имен и номеров
        nameAndPhone = myList.stream().map(a -> new PhoneName2(a.phone, a.name));

        // а теперь создать множество типа Set, вызвав метод collect()
        Set<PhoneName2> npSet = nameAndPhone.collect(Collectors.toSet());

        System.out.println("Имена и номера телефонов в множестве типа Set: ");
        for (PhoneName2 a : npSet)
            System.out.println(a.name + " " + a.phone);
    }


}
