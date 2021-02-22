package main.java.com.Vladimir_Beznossov.javacore.chapter15;

// Продемонстрировать применение ссылки на конструктор

// В функциональном интерфейсе МyFunc4 определяется метод, возвращающий ссылку на класс МyClass
interface MyFunc4 {
    MyClass2 func(int n);
}

class MyClass2 {
    private int val;

    MyClass2(int val) { this.val = val; }

    MyClass2() { val = 0; }

    int getVal () { return val; }
}

public class ConstructorRefDemo {
    public static void main(String[] args) {
        // Создать ссылку на конструктор класса МyClass2. Метод fuc() из интерфейса MyFunc4 принимает
        // аргумент, поэтому оператор new обращается к параметризированному конструктору класса МyClass2,
        // а не к его конструктору по умолчанию.
        MyFunc4 myClassCons = MyClass2::new;

        // создать экземляр класса МyClass2 по ссылке на его конструктор
        MyClass2 mc = myClassCons.func(100);

        System.out.println("Значение val в объекте mc равно " + mc.getVal());
    }
}
