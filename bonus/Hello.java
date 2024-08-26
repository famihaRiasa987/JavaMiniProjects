import java.util.Scanner;

public class Hello{
    public static void main(String[] args){
        System.out.print("What is your name? ");
        Scanner name = new Scanner(System.in);
        String userName = name.nextLine();
        System.out.println("Hello, " + userName + "!");
    }

}