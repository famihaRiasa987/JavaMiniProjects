package moes;
import customer.Account;
import customer.Alacarte;
import customer.Student;
import product.Media;
import java.util.ArrayList;

public class MoesImpl implements Moes {
    private ArrayList<Media> library;
    private ArrayList<Student> customers;

    public MoesImpl() {
        library = new ArrayList<>();
        customers = new ArrayList<>();
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
        return customers; // Allows access to the student list
    }

    public ArrayList<Media> getLibrary() {
        return library; // Allows access to the media library
    }
}
