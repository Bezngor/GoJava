package main.java.com.Vladimir_Beznossov.javacore.chapter15;

// Продемонстрировать применение ссылки на метод экземпляра

interface StringFunc3 {
    String func(String n);
}

class MyStringOps2 {
    String strReverse(String str) {
        String result = "";
        for (int i = str.length()-1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}

public class MethodRefDemo2 {
    static String stringOp(StringFunc3 sf, String str) {
        return sf.func(str);
    }

    public static void main(String[] args) {
        MyStringOps2 strOps2 = new MyStringOps2();
        String inStr = "Лямбда-выражения повышают эффективность Java";

        System.out.println(stringOp(strOps2::strReverse, inStr));
    }
}
