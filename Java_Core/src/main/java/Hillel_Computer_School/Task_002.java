package Hillel_Computer_School;

import java.util.Random;

public class Task_002 {

    public static void main(String[] args) {
        int[] array = new int[100];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        // Заполнение одномерного массива случайными числами.
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        // Нахождение самого минимального и самого максимального элементов массива.
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];

            if (array[i] < min)
                min = array[i];
        }

        // Вывод min и max элементов массива на экран.
        System.out.println("Максимальное число массива: " + max);
        System.out.println("Минимальное число массива: " + min);
    }
}
