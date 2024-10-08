package moes;

import customer.Account;
import customer.Alacarte;
import customer.Student;
import product.Media;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class MoesImpl implements Moes {

    private ArrayList<Student> customers;
    private ArrayList<Media> library;

    public MoesImpl() {
        library = new ArrayList<>();
        customers = new ArrayList<>();
    }

    // Constructor for loading from a file
    public MoesImpl(BufferedReader br) throws IOException {
        int mediaCount = Integer.parseInt(br.readLine());
        library = new ArrayList<>();
        for (int i = 0; i < mediaCount; i++) {
            library.add(new Media(br));
        }

        int studentCount = Integer.parseInt(br.readLine());
        customers = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            customers.add(new Student(br));
        }
    }

    // Save method to write to file
    public void save(BufferedWriter bw) throws IOException {
        // Save media list
        bw.write(String.valueOf(library.size()));
        bw.newLine();
        for (Media media : library) {
            media.save(bw);
        }

        // Save student list
        bw.write(String.valueOf(customers.size()));
        bw.newLine();
        for (Student student : customers) {
            student.save(bw);
        }
    }

    public void addMedia(Media media) {
        library.add(media);
    }

    public void addStudent(Student student) {
        customers.add(student);
    }

    public int getPoints(int studentIndex) {
        Account account = customers.get(studentIndex).getAccount();
        if (account instanceof Alacarte) {
            return ((Alacarte) account).getPointsRemaining();
        }
        return Integer.MAX_VALUE; // Unlimited accounts have no point limit
    }

    public String playMedia(int studentIndex, int mediaIndex) {
        Media media = library.get(mediaIndex);
        return customers.get(studentIndex).requestMedia(media);
    }

    public void buyPoints(int studentIndex, int points) {
        Student student = customers.get(studentIndex);
        Account account = student.getAccount();
        if (account instanceof Alacarte) {
            ((Alacarte) account).buyPoints(points);
        }
    }

    public String getStudentList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customers.size(); i++) {
            sb.append(i).append(") ").append(customers.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    public String getMediaList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < library.size(); i++) {
            sb.append(i).append(") ").append(library.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    public ArrayList<Student> getStudents() {
        return customers;
    }

    public ArrayList<Media> getLibrary() {
        return library;
    }
}
