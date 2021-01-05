import java.util.Scanner;
//Program to check if a string is the same when read backwards.
public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Input String: ");
        Scanner in = new Scanner(System.in);
        String p = in.next();
        System.out.println(checkPalindrome(p));
    }

    public static String checkPalindrome(String input){
        char[] pal = input.toCharArray();
        int corres = pal.length;
        for (int i=0; i<corres/2; i++) {
            if (pal[i] != pal[corres - i - 1]) {return input + " is NOT a palindrome";}
        }
        return input + " is a palindrome";
    }
}
