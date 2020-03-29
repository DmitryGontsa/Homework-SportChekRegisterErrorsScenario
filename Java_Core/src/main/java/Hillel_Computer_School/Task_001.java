package Hillel_Computer_School;

import java.util.Scanner;

public class Task_001 {

    public static void main(String[] args) {
        System.out.print("Введите любое слово: ");
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        System.out.println("Принято! Вы ввели слово: " + text);

        System.out.println(" ! ======= Выполняется проверка слова на Палиндром ======= ! ");
        boolean value = isPalindrome(text);

        if (value)
            System.out.println(" ! ======= Ваше слово: " + text + " - является Палиндромом! ======= ! ");
        else System.out.println(" ! ======= Ваше слово: " + text + " - Не является Палиндромом! ======= ! ");
    }

    public static boolean isPalindrome(String text) {
        // Удаление всех ненужных символов.
        String value = text.replaceAll("\\W", "");
        StringBuilder strBuilder = new StringBuilder(value);

        // Переворачивание строки.
        strBuilder.reverse();

        // Присвоение перевёрнутой строки.
        String invertedText = strBuilder.toString();

        // Возвращение сравнения двух строк, вне зависимости от регистра.
        return text.equalsIgnoreCase(invertedText);
    }
}
