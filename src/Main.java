import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        if(expression.length() < 5){
            throw new Exception();
        }
        System.out.println(Calc(expression));
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String arithmeticOperations(int a, int b, char action){
        String result = "";
        switch (action){
            case '+':
                result = String.valueOf(a+b);
                break;
            case '-':
                result = String.valueOf(a-b);
                break;
            case '*':
                result = String.valueOf(a*b);
                break;
            case '/':
                result = String.valueOf(a/b);
                break;
        }
        return result;
    }


    private static String Calc(String exp) throws Exception {
        char action;
        String[] expArray;

        if (exp.contains("+")) {
            action = '+';
            expArray = exp.split(" \\+ ");
        }
        else if (exp.contains("-")) {
            action = '-';
            expArray = exp.split(" - ");
        }
        else if (exp.contains("*")) {
            action = '*';
            expArray = exp.split(" \\* ");
        }
        else if (exp.contains("/")) {
            action = '/';
            expArray = exp.split(" / ");
        }
        else {
            throw new Exception();
        }

        if (expArray.length > 2) {
            throw new Exception();
        }

        String result = "";

        if (isDigit(expArray[0]) && isDigit(expArray[1])) {
            int a = Integer.parseInt(expArray[0]);
            int b = Integer.parseInt(expArray[1]);
            if ((a < 1 || a > 10) || (b < 1 || b > 10)) {
                throw new Exception();
            }
            result = arithmeticOperations(a, b, action);
        }
        else{
            try{
                int a = RomanNumeral.romanToArabic(expArray[0]);
                int b = RomanNumeral.romanToArabic(expArray[1]);
                if ((a < 1 || a > 10) || (b < 1 || b > 10)) {
                    throw new Exception();
                }
                result = RomanNumeral.arabicToRoman(Integer.parseInt(arithmeticOperations(a, b, action)));
            }
            catch (Exception e){
                throw new Exception();
            }
        }
        return result;
    }
}