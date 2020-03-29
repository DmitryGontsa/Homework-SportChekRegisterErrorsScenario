package Hillel_Computer_School;

public class Calculator_Runner {

    public static void main(String[] args) {
        // Ввод данных вычисления.
        double number1 = Data_Validation.getDouble();
        double number2 = Data_Validation.getDouble();
        char operations = Data_Validation.getOperation();

        // Выполнение вычисления.
        double result = Task_005_Calculator.calculationLogic(number1, number2, operations);

        // Вывод результата вычисления на экран.
        System.out.println("Результат операции: " + result);
    }
}
