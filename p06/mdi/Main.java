package mdi;

import customer.Student;
import moes.MoesImpl;
import product.Media;
import java.io.*;
import java.util.Scanner;

public class Main {
    private MoesImpl moes;
    private Menu menu;
    private boolean running;
    private Scanner scanner;
    private String filename;
    private boolean dirty;

    private static final String FILE_EXTENSION = ".moes";
    private static final String MAGIC_COOKIE = "MOES_MAGIC_COOKIE";
    private static final String FILE_VERSION = "1.0";

    public Main(MoesImpl moes, Menu menu, boolean running) {
        this.moes = moes;
        this.menu = menu;
        this.running = running;
        this.scanner = new Scanner(System.in);
        this.filename = null;
        this.dirty = false;

        menu.addMenuItem(new MenuItem("Exit", () -> endApp()));
        menu.addMenuItem(new MenuItem("New MOES File", () -> newMoes()));
        menu.addMenuItem(new MenuItem("Save MOES File", () -> save()));
        menu.addMenuItem(new MenuItem("Save As", () -> saveAs()));
        menu.addMenuItem(new MenuItem("Open MOES File", () -> open()));
        menu.addMenuItem(new MenuItem("List Media", () -> listMedia()));
        menu.addMenuItem(new MenuItem("Play Media", () -> playMedia()));
        menu.addMenuItem(new MenuItem("List Available Points", () -> listAvailablePoints()));
        menu.addMenuItem(new MenuItem("Buy Points", () -> buyPoints()));
        menu.addMenuItem(new MenuItem("Add Media", () -> addMedia()));
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
        dirty = true;
        System.out.println("Added Student: " + student);
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
        dirty = true;
    }

    private void listMedia() {
        if (moes.getLibrary().isEmpty()) {
            System.out.println("No media added yet.");
        } else {
            System.out.println(moes.getMediaList());
        }
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

    private void newMoes() {
        if (dirty) {
            System.out.print("You have unsaved data. Do you want to save it? (y/n): ");
            String response = scanner.nextLine().toLowerCase();
            if (response.equals("y")) {
                save();
            } else if (response.equals("n")) {
                System.out.println("Data discarded.");
            } else {
                System.out.println("Invalid input, aborting.");
                return;
            }
        }
        moes = new MoesImpl();  
        dirty = false; 
    }

    private void save() {
        if (filename == null || filename.isEmpty()) {
            System.err.println("Filename not specified. Use Save As to provide a filename.");
            return;
        }

        try {
            File existingFile = new File(filename);
            if (existingFile.exists()) {
                File backupFile = new File(filename + "~");
                if (!existingFile.renameTo(backupFile)) {
                    System.err.println("Failed to create backup file.");
                    return;
                }
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
                bw.write(MAGIC_COOKIE);
                bw.newLine();
                bw.write(FILE_VERSION);
                bw.newLine();
                moes.save(bw);
                dirty = false;  
                System.out.println("Data successfully saved to " + filename);
            }
        } catch (IOException e) {
            System.err.println("Failed to save data: " + e.getMessage());
        }
    }

    private void saveAs() {
        System.out.print("Enter new filename: ");
        String newFilename = scanner.nextLine();

        if (newFilename.isEmpty()) {
            System.out.println("Save cancelled.");
            return;
        }

        if (!newFilename.endsWith(FILE_EXTENSION)) {
            newFilename += FILE_EXTENSION; 
        }

        filename = newFilename;
        save();  
    }

    private void open() {
        System.out.print("Enter filename to open: ");
        String newFilename = scanner.nextLine();

        if (newFilename.isEmpty()) {
            System.out.println("Opening cancelled.");
            return;
        }

        if (!newFilename.endsWith(FILE_EXTENSION)) {
            newFilename += FILE_EXTENSION;  // Add extension if not present
        }

        try (BufferedReader br = new BufferedReader(new FileReader(newFilename))) {
            String magicCookie = br.readLine();
            String fileVersion = br.readLine();

            if (!MAGIC_COOKIE.equals(magicCookie) || !FILE_VERSION.equals(fileVersion)) {
                throw new IOException("Invalid file format");
            }

            MoesImpl newMoes = new MoesImpl(br);  
            moes = newMoes;
            filename = newFilename;
            dirty = false;  
            System.out.println("Data successfully loaded from " + filename);
        } catch (IOException e) {
            System.err.println("Failed to open file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("::::::::::::::::::::::::::::::000 :::: 000:::::::::::::::::::::::::::::");
        System.out.println("!                                                                     !");
        System.out.println("!            Mavs Online Entertainment System (MOES).                 !");
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
