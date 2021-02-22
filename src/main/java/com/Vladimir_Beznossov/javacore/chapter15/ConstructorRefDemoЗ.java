package main.java.com.Vladimir_Beznossov.javacore.chapter15;

// Реализовать простую фабрику классов, использую ссылку на конструктор

interface My_Func<R, T> {
    R func(T n);
}

// Простой обобщенный класс
class My_Class<T> {
    private T val;

    My_Class(T val) { this.val = val; }

    My_Class() { val = null; }

    T getVal() { return val; }
}

// Простой необобщенный класс
class My_Class2 {
    private String str;

    My_Class2(String str) { this.str = str; }

    My_Class2() { str = ""; }

    String getVal() { return str; }
}

public class ConstructorRefDemoЗ {
    // Фабричный метод для объектов разны классов.
    // У каждого класса должен быть свой конструктор, принимающй один параметр типа Т.
    // А параметр R обозначает тип создаваемого объекта.
    static <R, T> R myClassFactory (My_Func<R, T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String[] args) {

        // Создать ссылку на конструктор My_Class
        My_Func<My_Class<Double>, Double> myClassCons = My_Class<Double>::new;

        // Создать экземпляр класса My_Class, используя фабричный метод
        My_Class<Double> mc = myClassFactory(myClassCons, 100.1);
        System.out.println("Значение val в объекте mc равно " + mc.getVal());

        My_Func<My_Class2, String> myClassCons2 = My_Class2::new;
        My_Class2 mc2 = myClassFactory(myClassCons2, "Лямбда");
        System.out.println("Значение val в объекте mc2 равно " + mc2.getVal());
    }
}
