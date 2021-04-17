package main.java.com.Vladimir_Beznossov.javacore.chapter28;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class SqrtTransform extends RecursiveAction {
    // Пороговое значение
    final int seqTreshold = 1000;
    // обрабатываемый массив
    double[] data;
    // определить часть обрабатываемых данных
    int start, end;

    SqrtTransform(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    // Этот метод выполняет параллельное высисление
    @Override
    protected void compute() {
        if ((end - start) < seqTreshold) {
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
            int middle = (start + end) / 2;
            invokeAll( new SqrtTransform(data, start, middle),
                    new SqrtTransform(data, middle, end));
        }
    }
}

public class ForkJoinDemo {
    public static void main(String[] args) {
        // создать пул задач
        //ForkJoinPool fjp = new ForkJoinPool();

        double[] nums = new double[100_000];

        // присвоить некоторые значения
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }

        System.out.println("Часть исходной последовательности:");
        for (int i = 0; i < 10; i++)
            System.out.print(nums[i] + " ");
        System.out.println("\n");

        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);

        // Запустить главную задачу ForkJoinTask на выполнение
        //fjp.invoke(task);
        task.invoke();

        System.out.println("Часть преобразованной последовательности с точностью 4 зн. после запятой:");
        for (int i = 0; i < 10; i++)
            System.out.printf("%.4f ", nums[i]);
        System.out.println("\n");
    }
}
