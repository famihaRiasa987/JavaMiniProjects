import customer.Student;
import java.util.Scanner;

public class Main{
    private Moes moes = new Moes();
    private String output;
    private Menu menu = new Menu();
    private boolean running;
    String name;
    int id;
    String email;
    String accountype;
    Scanner scanner = new Scanner(System.in); 

    System.out.println("Enter student name: ");
    String name = scanner.nextLine();
    
    System.out.println("Enter student ID: ");
    int id = Integer.parseInt(scanner.nextLine());
    
    System.out.println("Enter student email: ");
    String email = scanner.nextLine();

    // Collect account type (Alacarte or Unlimited)
    System.out.println("Enter (a) for Alacarte or (u) for Unlimited: ");
    String accountType = scanner.nextLine();

    private void addStudent(){
        Student student = new Student( name, id, email, isAlacarte);
        moes.addStudent(student);
    } 
    private void listStudent(){
        System.out.println(moes.getStudentList());
    }











}