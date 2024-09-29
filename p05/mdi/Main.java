import customer.Student;
import moes.Moes;

import java.util.Scanner;

public class Main{
    private Moes moes = new Moes();
    private String output;
    private Menu menu = new Menu();
    private boolean running;

    private void addStudent(){
        Scanner scanner = new Scanner(System.in); 

    System.out.println("Enter student name: ");
    String name = scanner.nextLine();
    
    System.out.println("Enter student ID: ");
    int id = Integer.parseInt(scanner.nextLine());
    
    System.out.println("Enter student email: ");
    String email = scanner.nextLine();

    System.out.println("Enter (a) for Alacarte or (u) for Unlimited: ");
    String accountType = scanner.nextLine();

    boolean isAlacarte;
        if (accountType.equalsIgnoreCase("a")) {
            isAlacarte = true; 
        }
        else if (accountType.equalsIgnoreCase("u")) {
            isAlacarte = false; 
        }
        else{
            System.out.println("Invalid input, defaulting to Unlimited");
            isAlacarte = false;
        }

        Student student = new Student( name, id, email, isAlacarte);
        moes.addStudent(student);
    } 

    private void listStudent(){
        System.out.println(moes.getStudentList());
    }

    private void addMedia(){
        System.out.println("Title: ");
        String title = scanner.nextLine();

        System.out.println("URL: ");
        String url = scanner.nextLine();

        System.out.println("points: ");
        int points = scanner.nextInt();

        Media media = new Media(title, url, points );
        moes.addMedia(media);

    }

    private void listMedia(){
        System.out.println(moes.getMediaList());
    }
    private void playMedia(){
        System.out.println("Student number: ");
        int student_index = scanner.nextInt();
        System.out.println("Media number: ");
        int media_index = scanner.nextInt();

    }



}
