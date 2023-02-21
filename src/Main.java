import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Введите 2 арабских числа (2 + 2) или 2 римских числа (V - III) от 1 до 10 и оператор + - * /");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String a = calc(input) ;
        System.out.println(a);
    }

    public static String calc(String input) throws IOException {
        int num1, num2;
        String result = null;
        String oper = null;
        String cleanInput = input.replaceAll(" ", "");
        String[] vyraz = cleanInput.split("[\\+, \\-, *, /]");

        if (vyraz.length > 2) {
            throw new IOException("Доспустимо только 2 операнда.");
        }
        if (input.contains("+")) {
            oper = "+";
        } else if (input.contains("-")) {
            oper = "-";
        } else if (input.contains("*")) {
            oper = "*";
        } else if (input.contains("/")) {
            oper = "/";
        } else oper = null;

        if (oper == null) {
            throw new IOException("Неверный оператор");
        }

        String subnum1 = vyraz[0];
        String subnum2 = vyraz[1];
        String numnum = "1,2,3,4,5,6,7,8,9,10";
        String romnum = "I, II, III, IV, V, VI, VII, VIII, IX, X";
            if (numnum.contains(vyraz[0]) && numnum.contains(vyraz[1])) {
                num1 = Integer.parseInt(subnum1);
                num2 = Integer.parseInt(subnum2);
                int results = calculate(num1, num2, oper);
                result = String.valueOf(results);
                return result;
            } else if (romnum.contains(vyraz[0]) && romnum.contains(vyraz[1])){
                Rom rnum1 = Rom.valueOf(vyraz[0]);
                Rom rnum2 = Rom.valueOf(vyraz[1]);
                num1 = rnum1.getArabNum();
                num2 = rnum2.getArabNum();
                int resultsrom = calculate(num1, num2, oper);
                result = Rom.nameOf(resultsrom);
                if (resultsrom < 1) {
                    throw new IOException("Результатом работы калькулятора с римскими числами могут быть только положительные числа.");
                }else return result;
            } else throw new IOException("Калькулятор умеет работать только с арабскими или римскими цифрами одновременно.");
    }
        static int calculate ( int a, int b, String op) throws IOException {
            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new IOException("Числа должны быть от 1 до 10");
            }
            int resultato;
            switch (op) {
                case "+":
                    resultato = a + b;
                    break;
                case "-":
                    resultato = a - b;
                    break;
                case "*":
                    resultato = a * b;
                    break;
                case "/":
                    resultato = a / b;
                    break;
                default:
                    throw new IllegalArgumentException("Неверный знак операции.");
            }
            return resultato;
        }

}



