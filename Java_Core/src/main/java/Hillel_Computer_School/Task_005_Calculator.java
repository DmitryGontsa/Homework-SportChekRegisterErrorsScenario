package Hillel_Computer_School;

import static Hillel_Computer_School.Data_Validation.getDouble;
import static Hillel_Computer_School.Data_Validation.getOperation;

public class Task_005_Calculator {

    public static double calculationLogic(double number1, double number2, char operations) {
        double result;
        switch (operations) {
            case '+':
                result = sumNumbers(number1, number2);
                break;
            case '-':
                result = subNumbers(number1, number2);
                break;
            case '*':
                result = mulNumbers(number1, number2);
                break;
            case '/':
                result = divNumbers(number1, number2);
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calculationLogic(number1, number2, getOperation()); // Использование рекурсии.
        }
        return result;
    }

    public static double sumNumbers(double number1, double number2) {
        double sumResult = number1 + number2;
        return sumResult;
    }

    public static double subNumbers(double number1, double number2) {
        double subResult = number1 - number2;
        return subResult;
    }

    public static double mulNumbers(double number1, double number2) {
        double mulResult = number1 * number2;
        return mulResult;
    }

    public static double divNumbers(double number1, double number2) {
        double divResult = 0;
        if (number2 == 0) {
            System.out.println("Ошибка! Деление на ноль невозможно! Повторите попытку, введите другие числа.");
            calculationLogic(getDouble(), getDouble(), getOperation());
        } else divResult = number1 / number2;
        return divResult;
    }
}
