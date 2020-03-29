package Hillel_Computer_School;

import java.util.Scanner;

public class Data_Validation {

    static Scanner scan = new Scanner(System.in);

    public static double getDouble() {
        System.out.println("Введите число: ");
        double num;
        if (scan.hasNextDouble()) {
            num = scan.nextDouble();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте ещё раз!");
            scan.next(); // Рекурсия
            num = getDouble();
        }
        return num;
    }

    public static char getOperation() {
        System.out.println("Введите операцию: ");
        char operation;
        if (scan.hasNext()) {
            operation = scan.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте ещё раз!");
            scan.next(); // Рекурсия
            operation = getOperation();
        }
        return operation;
    }
}
