package Hillel_Computer_School;

import java.util.Scanner;

public class Task_007 {

    public static void main(String[] args) {
        System.out.print("Введите положительное десятичное число: " + "\n");
        Scanner scan = new Scanner(System.in);

        int number = scan.nextInt();
        System.out.println("Принято! Вы ввели число: " + number + "\n");

        if (number < 0) {
            System.out.println("Ошибка! Вы ввели отрицательное число. Повторите попытку!");
        } else if (number == 0) {
            System.out.println("Ошибка! Вы ввели число 0. Повторите попытку!");
        } else {
            System.out.println("! === Выполняется перевод числа из 10-й системы счисления в двоичную === !" + "\n");
            System.out.print("Число " + number + " в двоичной системе счисления равно: ");
            convertToBinary(number);
        }
    }

    public static void convertToBinary(int number) {
        int i = bitsInNumber(number);
        int bit;
        while (--i >= 0) {
            bit = (number & (1 << i)) == 0 ? 0 : 1;
            System.out.print(bit);
        }
    }

    public static int bitsInNumber(int number) {
        int res = 0;
        while (number > 0) {
            number >>= 1;
            res++;
        }
        return res;
    }
}
