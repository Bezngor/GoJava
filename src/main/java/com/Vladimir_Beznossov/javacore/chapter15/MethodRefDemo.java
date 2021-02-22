package main.java.com.Vladimir_Beznossov.javacore.chapter15;

// Продемонстрировать ссылку на статический метод

interface StringFunc2 {
    String func(String n);
}

class MyStringOps {
    static String strReverse(String str) {
        String result = "";
        for (int i = str.length()-1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}

public class MethodRefDemo{
    // В этом методе функциональны интерфейс указывается в качестве типа первого его параметра.
    // Следовательно, ему может быть передан любой экземляр этого интерфейса, включая и ссылку на метод.
    static String stringOp(StringFunc2 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность Java";
        String outStr;

        // Здесь ссылка на метод strReverse() передается методу stringOp()
        outStr = stringOp(MyStringOps::strReverse, inStr);

        System.out.println("Исходная строка: " + inStr);
        System.out.println("Обращенная строка: " + outStr);
    }
}
