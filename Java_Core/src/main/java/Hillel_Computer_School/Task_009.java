package Hillel_Computer_School;

import java.util.Scanner;

public class Task_009 {

    public static void main(String[] args) {

        System.out.println("! ===== Заполнение двумерного массива по спирали, начиная с середины. ===== !");

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество строк массива: ");
        int quantity1 = scan.nextInt();

        System.out.println("Введите количество столбцов массива: ");
        int quantity2 = scan.nextInt();

        System.out.println("! ===== Выполняется заполнение двумерного массива. ===== !");
        TwoDimensionalArray.twoDimensionalArrayLogic(quantity1, quantity2);

        System.out.println("! ===== Заполнение двумерного массива по спирали, начиная с середины - ВЫПОЛНЕНО! ===== !");
    }
}
