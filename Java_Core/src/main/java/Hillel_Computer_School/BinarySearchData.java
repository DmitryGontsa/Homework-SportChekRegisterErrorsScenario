package Hillel_Computer_School;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchData {

    static Scanner scan = new Scanner(System.in);
    static int counter, num, item, array[], first, last;

    public static int getNum() {
        return num;
    }

    public void setArraySize() {
        // Создаём массив введённого пользователем размера.
        num = scan.nextInt();
        array = new int[num];
    }

    public void setArrayData() {
        // Заполняем массив, вводя элементы в консоль.
        for (counter = 0; counter < num; counter++)
            array[counter] = scan.nextInt();

        // Выполняем сортировку элементов массива.
        Arrays.sort(array);
    }

    public void setElementForBinarySearch() {
        // Сетим элемент для бинарного поиска, введённый пользователем.
        item = scan.nextInt();
        first = 0;
        last = num - 1;
    }

    public void performingBinarySearchByArray() {
        // Метод binarySearchLogic принимает начальный и последний индекс,
        // а также число для поиска.
        BinarySearchByArray.binarySearchLogic(array, first, last, item);
    }
}
