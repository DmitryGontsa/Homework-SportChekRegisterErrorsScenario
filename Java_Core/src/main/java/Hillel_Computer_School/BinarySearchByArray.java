package Hillel_Computer_School;

public class BinarySearchByArray {

    // Логика выполнения бинарного поиска по массиву.
    public static void binarySearchLogic(int[] array, int first, int last, int item) {

        int position;

        // Для подсчёта количества сравнений.
        int comparisonCount = 1;

        // Для начала, найдём индекс среднего элемента массива.
        position = (first + last) / 2;

        while ((array[position] != item) && (first <= last)) {

            comparisonCount++;

            if (array[position] > item) {  // Если число заданного для поиска,
                last = position - 1;  // уменьшаем позицию на 1,
            } else {
                first = position + 1;  // иначе, увеличиваем на 1.
            }

            position = (first + last) / 2;
        }


        if (first <= last) {

            System.out.println(item + " - является " + ++position + " элементом в массиве! " + "\n");
            System.out.println("Метод бинарного поиска нашёл число после " + comparisonCount +
                    " сравнений." + "\n");

        } else {

            System.out.println("Элемент не найден в массиве. Метод бинарного поиска закончил работу после "
                    + comparisonCount + " сравнений." + "\n");

        }
    }
}
