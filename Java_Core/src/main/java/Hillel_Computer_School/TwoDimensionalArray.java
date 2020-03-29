package Hillel_Computer_School;

public class TwoDimensionalArray {

    public static void twoDimensionalArrayLogic(int number1, int number2) {
        // Заполняем массив, где m - количество строк, а n - количество столбцов.
        int m, n;
        m = number1;
        n = number2;

        // Задаём числа внутри массива.
        int s = m * n;

        // Объявляем и инициализируем массив.
        int[][] array = new int[m][n];

        // Заполняем периметр массива по часовой стрелке.
        for (int y = 0; y < n; y++) {
            array[0][y] = s;
            s--;
        }
        for (int x = 1; x < m; x++) {
            array[x][n - 1] = s;
            s--;
        }
        for (int y = n - 2; y >= 0; y--) {
            array[m - 1][y] = s;
            s--;
        }
        for (int x = m - 2; x > 0; x--) {
            array[x][0] = s;
            s--;
        }

        // Заполняем массив и задаём координаты ячейки, которую необходимо
        // заполнить следующей, после заполнения периметра.
        int c = 1;
        int d = 1;


        // Условие для выхода из внешнего цикла - (s > 1).
        while (s > 1) {

            // Перемещение вправо.
            while (array[c][d + 1] == 0) {
                array[c][d] = s;
                s--;
                d++;
            }

            // Перемещение вниз.
            while (array[c + 1][d] == 0) {
                array[c][d] = s;
                s--;
                c++;
            }

            // Перемещение влево.
            while (array[c][d - 1] == 0) {
                array[c][d] = s;
                s--;
                d--;
            }

            // Перемещение вверх.
            while (array[c - 1][d] == 0) {
                array[c][d] = s;
                s--;
                c--;
            }
        }


        // Убираем незаполненную в центре ячейку,
        // при помощи следующего цикла.
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (array[x][y] == 0) {
                    array[x][y] = s;
                }
            }
        }


        // Выводим массив в консоль.
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (array[x][y] < 10) {
                    System.out.print(array[x][y] + ",  ");
                } else {
                    System.out.print(array[x][y] + ", ");
                }
            }
            System.out.println("");
        }
    }
}
