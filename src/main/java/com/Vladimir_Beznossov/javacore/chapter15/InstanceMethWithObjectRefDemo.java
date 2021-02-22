package main.java.com.Vladimir_Beznossov.javacore.chapter15;

// Использовать ссылку на метод экземляра вместе с разны объектам

// Функциональны интерфейс с методом, принимающим два ссылочных аргумента и возвращающим логическое значение
interface MyFunc<T> {
    boolean func(T v1, T v2);
}

// Класс для хранения максимальной темературы за день
class HighTemp {
    private int hTemp;

    HighTemp(int hTemp) {
        this.hTemp = hTemp;
    }

    // возвратить логическое значение true, если вызывающй объект типа HighTemp имеет
    // такую же темературу, как и у объекта ht2
    boolean someTemp(HighTemp h2) {
        return hTemp == h2.hTemp;
    }

    // возвратить логическое значение true, если вызывающй объект типа HighTemp имеет
    // темературу ниже, чем у объекта ht2
    boolean lessThenTemp(HighTemp h2) {
        return hTemp < h2.hTemp;
    }
}

public class InstanceMethWithObjectRefDemo {
    // Метод, возвращающй количество экземляров объекта, найденных по критериям,
    // задаваем параметром функционального интерфейс MyFunc
    static <T> int counter(T[] vals, MyFunc<T> f, T v) {
        int counter = 0;

        for (int i = 0; i < vals.length; i++) {
            if (f.func(vals[i], v)) counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        int counter;

        // создать массив объектов типа HighTemp
        HighTemp[] weekDayHighs = { new HighTemp(89),
                new HighTemp(82), new HighTemp(84),
                new HighTemp(89), new HighTemp(90),
                new HighTemp(89), new HighTemp(91),
                new HighTemp(83), new HighTemp(85) };

        // Использовать метод counter() вместе с массивам объектов типа HighTemp.
        // Обратите вниание на то, что ссылка на метод экземляра someTemp()
        // передается в качестве второго парамтра
        counter = counter(weekDayHighs, HighTemp::someTemp, new HighTemp(89));
        System.out.println("Дней, когда максиальная температура была 89: " + counter);

        // Создать еще один массив
        HighTemp[] weekDayHighs2 = { new HighTemp(32),
                new HighTemp(22), new HighTemp(24),
                new HighTemp(19), new HighTemp(90),
                new HighTemp(18), new HighTemp(12),
                new HighTemp(-1), new HighTemp(13) };

        counter = counter(weekDayHighs2, HighTemp::someTemp, new HighTemp(12));
        System.out.println("Дней, когда максиальная температура была 12: " + counter);

        counter = counter(weekDayHighs, HighTemp::lessThenTemp, new HighTemp(89));
        System.out.println("Дней, когда максиальная температура была меньше 89: " + counter);

        counter = counter(weekDayHighs2, HighTemp::lessThenTemp, new HighTemp(18));
        System.out.println("Дней, когда максиальная температура была меньше 18: " + counter);
    }
}
