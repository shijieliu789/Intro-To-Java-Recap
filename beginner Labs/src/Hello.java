import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {
        String greeting = new String("Hello!");

        Scanner in = new Scanner(System.in);
        System.out.println("Input Your name: ");
        String name = in.nextLine();

        System.out.println(greeting + " " + name);
    }
}
