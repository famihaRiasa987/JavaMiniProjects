package mdi;

import customer.Student;
import moes.Moes;
import moes.MoesImpl;
import product.Media;
import java.util.Scanner;

public class Main {
    private MoesImpl moes;
    private Menu menu;
    private boolean running;
    private Scanner scanner;

    public Main(MoesImpl moes, Menu menu, boolean running) {
        this.moes = moes;
        this.menu = menu;
        this.running = running;
        this.scanner = new Scanner(System.in);

        menu.addMenuItem(new MenuItem("Exit", () -> endApp()));
        menu.addMenuItem(new MenuItem("List Media", () -> listMedia()));
        menu.addMenuItem(new MenuItem("Play Media", () -> playMedia()));
        menu.addMenuItem(new MenuItem("List Available Points", () -> listAvailablePoints()));
        menu.addMenuItem(new MenuItem("Buy Points", () -> buyPoints()));
        menu.addMenuItem(new MenuItem("Add media", () -> addMedia()));
        menu.addMenuItem(new MenuItem("List all Students", () -> listStudent()));
        menu.addMenuItem(new MenuItem("Add a Student", () -> addStudent()));

        }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter (a) for Alacarte or (u) for Unlimited: ");
        String accountType = scanner.nextLine();

        boolean isAlacarte = accountType.equalsIgnoreCase("a");

        Student student = new Student(name, id, email, isAlacarte);
        moes.addStudent(student);
        System.out.println("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("  Added Student: " + student.toString());
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
    }

    private void listStudent() {
        System.out.println(moes.getStudentList());
    }

    private void addMedia() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("URL: ");
        String url = scanner.nextLine();

        System.out.print("Points: ");
        int points = Integer.parseInt(scanner.nextLine());

        Media media = new Media(title, url, points);
        moes.addMedia(media);
    }

    private void listMedia() {
        if (moes.getLibrary().isEmpty()) {
            System.out.println("No media added yet.");
        } else {
            System.out.println(moes.getMediaList());
        }
        System.out.println();
    }
    
    private void playMedia() {
        if (moes.getStudents().isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }
    
        if (moes.getLibrary().isEmpty()) {
            System.out.println("No media added yet.");
            return;
        }
    
        System.out.print("Student number: ");
        int studentIndex = scanner.nextInt();
    
        System.out.print("Media number: ");
        int mediaIndex = scanner.nextInt();
        scanner.nextLine(); 

        if (studentIndex < 0 || studentIndex >= moes.getStudents().size()) {
            System.err.println("Invalid student number.");
            return;
        }
    
        if (mediaIndex < 0 || mediaIndex >= moes.getLibrary().size()) {
            System.err.println("Invalid media number.");
            return;
        }
    
        System.out.println(moes.playMedia(studentIndex, mediaIndex));
    }
    

    private void listAvailablePoints() {
        System.out.print("Student number: ");
        int studentIndex = scanner.nextInt();
        scanner.nextLine(); 
        if (studentIndex < 0 || studentIndex >= moes.getStudents().size()) {
            System.err.println("Invalid student number.");
            return;
        }

        System.out.print("Available points: " + moes.getPoints(studentIndex));
        System.out.println();
    }

    private void buyPoints() {
        System.out.print("Student number: ");
        int studentIndex = scanner.nextInt();

        if (studentIndex < 0 || studentIndex >= moes.getStudents().size()) {
            System.err.println("Invalid student number.");
            return;
        }

        int buyPoints = -1;
        while (buyPoints < 0) {
            System.out.print("How many additional points do you want to buy? ");
            buyPoints = scanner.nextInt();

            if (buyPoints < 0) {
                System.out.println("No purchasing negative points! Try Again.");
            }
        }

        moes.buyPoints(studentIndex, buyPoints);
    }

    private void mdi() {
        while (running) {
            
            System.out.println(menu); 
            System.out.print("Selection? ");
            int userInput = scanner.nextInt();
            scanner.nextLine(); 
            

            if (userInput >= 0 && userInput < menu.size()) {
                menu.run(userInput);
            } else {
                System.out.println("Invalid selection. Please choose a valid option.");
            }
        }
    }

    private void endApp() {
        System.out.println("Exiting Moes...");
        running = false;
    }

    public static void main(String[] args) {
        System.out.println("::::::::::::::::::::::::::::::000 :::: 000:::::::::::::::::::::::::::::");
        System.out.println("!                                                                     !");
        System.out.println("!    Mavs Online Entertainment System (MOES).                         !");
        System.out.println("!                            FAMIHA                                   !");
        System.out.println("!                                                                     !");
        System.out.println("::::::::::::::::::::::::::::::000 :::: 000:::::::::::::::::::::::::::::");
        System.out.println();
        MoesImpl moes = new MoesImpl();
        Menu menu = new Menu();
        boolean running = true;

        Main mediaPlayer = new Main(moes, menu, running);
        mediaPlayer.mdi();
    }
}
