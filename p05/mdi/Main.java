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
        else if(accountType.equalsIgnoreCase("u")) {
            isAlacarte = false; 
        }
        else
        {
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
        scanner.nextLine();


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
        scanner.nextLine();


        String result = moes.playMedia(studentIndex, mediaIndex);
        System.out.println(result);

    }
    private void listAvailablePoints() {
        System.out.println("Student number: ");
        int studentIndex = scanner.nextInt();
        scanner.nextLine(); 
        String result = moes.getPoints(studentIndex);
        System.out.println("Available points for student " + studentIndex + ": " + result);
    }

    private void buyPoints(){
        System.out.println("Student number: ");
        int studentIndex = scanner.nextInt();
        scanner.nextLine(); 

        int current_points = moes.getPoints(studentIndex);
        System.out.println("How many additional Points u want to buy? ");
        int buy_points = scanner.nextInt();

        int buyPoints = -1;
        while (buyPoints < 0) {
            System.out.println("How many additional points do you want to buy? ");
            buyPoints = scanner.nextInt();
    
            if (buyPoints < 0) {
                System.out.println("No purchasing negative points! Try Again.");
            }
        }
    
        String result = moes.buyPoints(studentIndex, buyPoints);
        System.out.println("Available points now: " + result);

        
    }

    
    public Main(Moes moes, string output, Menu menu, boolean running){
        this.moes = moes;
        this.output = output;
        this.menu = menu;
        this.running = running;
        this.scanner = new Scanner(System.in);

        MenuItem exitItem = new MenuItem("Exit", () -> endApp());
        MenuItem listMedia = new MenuItem("List Media",() -> listMedia());
        MenuItem playMediaItem = new MenuItem("Play Media", () -> playMedia());
        MenuItem listAvailablePointsItem = new MenuItem("List Available Points", () -> listAvailablePoints());
        MenuItem buyPointsItem = new MenuItem("Buy Points", () -> buyPoints());
        MenuItem listStudent = new MenuItem("List all Student", ()->listStudent());
        MenuItem addStudent = new MenuItem("Add a Student", ()->addStudent());


    }
    private void mdi(){
        while(running){
            System.out.println("Selection? ");
            Object user_input = scanner.nextLine();
            if(user_input!=null){
                menu.run(user_input);
            }

        }
    }
    private void endApp() {
        System.out.println("Exiting Moes...");
        running = false;
    }
  
    public static void main(str[] args){
        Moes moes = new Moes();
        Menu menu = new Menu();
        String output = "";
        boolean running = true;


        Main media_player = new Main(moes,output,menu, running );
        media_player.mdi();

    }

}
