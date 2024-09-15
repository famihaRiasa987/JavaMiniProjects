import moes.MoesImpl;
import product.Media;
import customer.Student;

import java.util.Scanner;

public class CheckP04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        MoesImpl moes = new MoesImpl();

        moes.addStudent(new Student("A. Media Hound", 1234567890, "amh7890@uta.edu", false)); // Alacarte
        moes.addStudent(new Student("Casual Carl", 1234567891, "cc7891@uta.edu", true)); // Unlimited

        System.out.print("Buy how many points for Casual Carl? ");
        int pointsToBuy = in.nextInt();
        moes.buyPoints(1, pointsToBuy);

        moes.addMedia(new Media("The Terror of Tiny Town", 
                                "https://en.wikipedia.org/wiki/File:The_Terror_of_Tiny_Town.webm",
                                3));
        moes.addMedia(new Media("The Mechanical Monsters (Superman)", 
                                "https://www.youtube.com/watch?v=6LEfzup0aNs",
                                5));

        System.out.print("\nMOES Users\n\n" + moes.getStudentList() + "\nWhich user? ");
        int studentIndex = in.nextInt(); in.nextLine();
        int points = moes.getPoints(studentIndex);
        if (points == Integer.MAX_VALUE)
            System.out.println("Unlimited Account");
        else
            System.out.println("Available points: " + moes.getPoints(studentIndex));

        System.out.print("\nMOES Media\n\n" + moes.getMediaList() + "\nWhich media? ");
        int mediaIndex = in.nextInt(); in.nextLine();

        System.out.println(moes.playMedia(studentIndex, mediaIndex));

        System.out.println("Points remaining: " + moes.getPoints(studentIndex));
    }
}
