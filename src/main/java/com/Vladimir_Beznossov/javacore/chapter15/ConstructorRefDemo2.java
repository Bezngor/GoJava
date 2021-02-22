package main.java.com.Vladimir_Beznossov.javacore.chapter15;

// Продемонстрировать применение ссылки на конструктор обобщенного класса

interface MyFunc5<T> {
    MyClass3<T> func(T n);
}

class MyClass3<T> {
    private T val;

    MyClass3(T val) { this.val = val; }

    MyClass3() { val = null; }

    T getVal() { return val; }
}

public class ConstructorRefDemo2 {
    public static void main(String[] args) {
        MyFunc5<Integer> myClassCons = MyClass3<Integer>::new;

        MyClass3<Integer> mc = myClassCons.func(100);
        System.out.println("Значение val в объекте mc равно " + mc.getVal());
    }
}
