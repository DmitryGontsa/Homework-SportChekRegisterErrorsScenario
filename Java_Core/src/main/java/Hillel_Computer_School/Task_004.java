package Hillel_Computer_School;

import java.util.Random;

public class Task_004 {

    public static void main(String[] args) {
        int[] array = new int[100];

        // Заполнение одномерного массива случайными числами.
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        // Нахождение суммы всех элементов массива, которые нацело делятся на 2.
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                result += array[i];
            }
        }

        // Вывод результата на экран.
        System.out.println("Сумма всех элементов массива, которые нацело делятся на 2: " + result);
    }
}
