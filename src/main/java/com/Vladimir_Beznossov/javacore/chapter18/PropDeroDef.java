package main.java.com.Vladimir_Beznossov.javacore.chapter18;

// Использовать список свойств по умолчанию

import java.util.Properties;
import java.util.Set;

public class PropDeroDef {
    public static void main(String[] args) {
        Properties defList = new Properties();
        defList.put("Флорида", "Тэлесси");
        defList.put("Висконсин", "Мэдисон");

        Properties capitals = new Properties(defList);
        capitals.put("Иллинойс", "Спрингфилд");
        capitals.put("Миссури", "Джефферсон-Сити");
        capitals.put("Вашингтон", "Олимпия");
        capitals.put("Калифорния", "Сакраменто");
        capitals.put("Индиана", "Индианаполис");

        // получить множество ключей
        Set<?> states = capitals.keySet();

        // показать все штаты и их столицы
        for (Object name : states) {
            System.out.println("Столица штата: " + name + " - " + capitals.getProperty((String)name) + ".");
        }
        System.out.println();

        // найти штат, отсутствующий в списке, указав значения, выбираемые по умолчанию
        String str = capitals.getProperty("Флорида", "не найдена");
        System.out.println("Столица штата Флорида " + str + ".");
    }
}
