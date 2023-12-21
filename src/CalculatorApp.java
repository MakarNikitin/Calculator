import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String stringExpression = sc.nextLine();
        System.out.println("Введите выражение");
        System.out.println(calc(stringExpression));
    }

    public static String calc(String input) {
        InputSeparation separation = new InputSeparation();
        NumberSystemChecker numberSystemChecker = new NumberSystemChecker();
        CalculationOfValues calculationOfValues = new CalculationOfValues();
        ExceptionChecker exceptionChecker = new ExceptionChecker();
        String[] sortedArray = separation.separate(input);
        exceptionChecker.checkInput(sortedArray);
        return calculationOfValues.calculatingOfValues(sortedArray, numberSystemChecker.rimOrArabianChecking(sortedArray));
    }
}