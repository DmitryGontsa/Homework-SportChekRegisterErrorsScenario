package Hillel_Computer_School;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_006 {

    public static void main(String[] args) {
        System.out.print("Введите Ваше словосочетание: " + "\n");
        Scanner scan = new Scanner(System.in);

        String text1 = scan.nextLine();
        System.out.println("Принято! Вы ввели: " + text1 + "\n");

        System.out.print("Введите Ваше слово, количество повторений которого должно быть посчитано в строке: " + "\n");
        String text2 = scan.nextLine();
        System.out.println("Принято! Вы ввели: " + text2 + "\n");

        System.out.println("! ========== Выполняется подсчёт слов в строке ========== !");
        Pattern pattern = Pattern.compile(text2);
        Matcher matcher = pattern.matcher(text1);

        int wordCount = 0;
        while (matcher.find()) {
            System.out.println(matcher.group());
            wordCount++;
        }
        
        System.out.println("Количество повторений слова " + text2 + " в Вашей строке равно: " + wordCount);
    }
}
