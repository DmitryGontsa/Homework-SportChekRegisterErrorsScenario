package Hillel_Computer_School;

import java.util.Random;

public class Task_003 {

    public static void main(String[] args) {
        int[] array = new int[100];

        // Заполнение одномерного массива случайными числами.
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        // Нахождение среднего арифметического всех элементов массива.
        double average = 0;
        if (array.length > 0) {
            double sum = 0;
            for (int j = 0; j < array.length; j++) {
                sum += array[j];
            }
            average = sum / array.length;
        }

        // Вывод среднего арифметического числа на экран.
        System.out.println("Среднее арифметическое число всех элементов массива: " + average);
    }
}
