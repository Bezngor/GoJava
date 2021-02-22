package main.java.com.Vladimir_Beznossov.javacore.chapter15;

// Передать лямбда-выражение в качестве аргумента методу

interface StringFunc {
    String func(String n);
}

public class LambdasAsArgumentsDemo {
    // Первый параметр этого метода имеет тип функционального интерфейса. Следовательно,
    // ему можно передать ссылку на любой экземпляр этого интерфейса, включая экземпляр,
    // создаваемый в лямбда-выражении. А второй параметр обозначает обрабатываемую символьную строку.
    static String stringOp(StringFunc sf, String n) {
        return sf.func(n);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность Java";
        String outStr;

        System.out.println("Это исходная строка: " + inStr);
        // Ниже приведено простое лямбда-выражение, преобразующее в верхний регистр букв все
        // символы исходной строки, передаваемой методу stringOp()
        outStr = stringOp((str) -> str.toUpperCase(), inStr);
        System.out.println("Это строка в верхнем регистре: " + outStr);

        // А здесь передается блочное лямбда-выражение, удаляющее пробелы из исходной символьной строки
        outStr = stringOp((str) -> {
            String result = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ')
                    result += str.charAt(i);
            }
            return result;
        }, inStr);
        System.out.println("Это строка с удаленными пробелами: " + outStr);

        // Конечно, можно передать и экземпляр интерфейса StringFunc, созданный в предыдущем
        // лямбда-выражении. Например, после следующего объявления ссылка reverse делается на
        // экземпляр интерфейса StringFnc
        StringFunc reverse = (str) -> {
            String result = "";
            for (int i = str.length()-1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        // А теперь ссылку reverse можно передать в качестве первого параметра методу stringOp()
        System.out.println("Этo обращенная строка : " + stringOp(reverse, inStr));
    }
}
