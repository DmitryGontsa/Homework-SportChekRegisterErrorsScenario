package Hillel_Computer_School;

public class Task_008 {

    public static void main(String[] args) {
        BinarySearchData binarySearchData = new BinarySearchData();

        System.out.println("Введите количество элементов массива: ");
        binarySearchData.setArraySize();

        System.out.println("Введите " + BinarySearchData.getNum() + " чисел.");
        binarySearchData.setArrayData();

        System.out.println("Введите элемент для бинарного поиска: ");
        binarySearchData.setElementForBinarySearch();

        System.out.println("! ======= Выполняется бинарный поиск по массиву ======= !" + "\n");
        binarySearchData.performingBinarySearchByArray();
        System.out.println("! ======== Бинарный поиск по массиву Завершён! ======== !" + "\n");
    }
}
