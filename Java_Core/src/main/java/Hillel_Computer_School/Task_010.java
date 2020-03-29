package Hillel_Computer_School;

public class Task_010 {

    public static void main(String[] args) {

        System.out.println("! ===== Перестановка местами 4 и 5 строк, в целочисленной матрице размерностью - 5x5 ===== !");

        // Дана целочисленная матрица, размерностью 5×5.
        int array[][] = {
                {1, 6, 7, 9, 10},
                {2, 5, 8, 8, 11},
                {3, 4, 9, 9, 15},
                {2, 5, 8, 8, 11},
                {3, 4, 9, 9, 15}};

        // Вывод в консоль текущего массива.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        int[] buffer1 = new int[5];
        int[] buffer2 = new int[5];

        int counter1 = 0;
        for (int i = 3; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                buffer1[counter1] = array[i][j];
                counter1++;
            }
        }

        int counter2 = 0;
        for (int i = 4; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buffer2[counter2] = array[i][j];
                counter2++;
            }
        }

        int counter3 = 0;
        for (int i = 3; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = buffer2[counter3];
                counter3++;
            }
        }

        int counter4 = 0;
        for (int i = 4; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = buffer1[counter4];
                counter4++;
            }
        }

        // Вывод в консоль массива, с переставленными местами 4 и 5 строк.
        System.out.println();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}






