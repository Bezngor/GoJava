package main.java.com.Vladimir_Beznossov.javacore.chapter15;

// Сгенерировать исключение из лямбда-выражения

interface DoubleNumericArrayFunc {
    double func(double[] n) throws EmptyArrayException;
}

class EmptyArrayException extends Exception {
    EmptyArrayException() {
        super("Массив пуст");
    }
}

public class LambdaExceptionDemo {
    public static void main(String[] args) throws EmptyArrayException {
        double[] values = {1.0, 2.0, 3.0, 4.0};

        // В этом лямбда-выражении вычисляется среднее числовых значений типа double в массиве
        DoubleNumericArrayFunc average = (n) -> {
            if (n.length == 0) throw new EmptyArrayException();

            double sum = 0;
            for (int i = 0; i < n.length; i++) {
                sum += n[i];
            }
            return sum / n.length;
        };

        System.out.println("Среднее равно: " + average.func(values));

        // Эта строка кода приводит к генерированию исключения
        System.out.println("Среднее равно: " + average.func(new double[0]));

    }
}
