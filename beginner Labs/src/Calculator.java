import java.util.Scanner;
//performs + - * / operations on doubles in formats of 23+6 etc

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the function: ");
        String input = in.next();

        String[] arr = input.split("[-+*/]");

        char[] symbol = input.toCharArray();
        int symbolIndex = arr[0].length();
        char operator = symbol[symbolIndex];

        double ans = 0;
        double num1 = Double.parseDouble(arr[0]);
        double num2 = Double.parseDouble(arr[1]);
        switch (operator){
            case '+':
                ans = num1 + num2;
                break;

            case '-':
                ans = num1 - num2;
                break;

            case '*':
                ans = num1 * num2;
                break;

            case '/':
                ans = num1 / num2;
                break;
            default:
                System.out.println("Error! Invalid Operator please use either + - / *. ");
        }

        System.out.println(num1 + " " + operator + " " + num2 + " " + "= " + ans);
    }
}
