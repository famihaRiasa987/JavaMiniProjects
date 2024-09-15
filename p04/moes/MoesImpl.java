package moes;

import customer.Account;
import customer.Alacarte;
import customer.Student;
import customer.Unlimited;
import product.Media;

import java.util.ArrayList;

/**
 * Implementation of Moes interface.
 * 
 * @author Famiha Riasa
 * @version 0.2
 * @since 1.0
 * 
 */
public class MoesImpl implements Moes {
    private ArrayList<Media> library = new ArrayList<>();
    private ArrayList<Student> customers = new ArrayList<>();

    /**
     * Constructs a MoesImpl object.
     * @since 1.0
     */
    public MoesImpl() {

    }

    /**
     * Adds media to the library.
     * 
     * @param media the Media object to add
     * @since 1.0
     * 
     */
    @Override
    public void addMedia(Media media) {
        library.add(media);
    }

    /**
     * Adds a student to the system.
     * 
     * @param student the Student object to add
     * @since 1.0
     * 
     */
    
    public void addStudent(Student student) {
        customers.add(student);
    }

    /**
     * Gets points for a student.
     * 
     * @param studentIndex the index of the student
     * @return points or max value for Unlimited accounts
     * @since 1.0
     * 
     */
    @Override
    public int getPoints(int studentIndex) {
        Account account = customers.get(studentIndex).getAccount();
        if (account instanceof Alacarte) {
            return ((Alacarte) account).getPointsRemaining();
        }
        return Integer.MAX_VALUE;
    }

    /**
     * Plays media for a student.
     * 
     * @param studentIndex  index of  student
     * @param mediaIndex  index of  media
     * @return result of play 
     * @since 1.0
     * 
     */
    @Override
    public String playMedia(int studentIndex, int mediaIndex) {
        Media media = library.get(mediaIndex);
        return customers.get(studentIndex).requestMedia(media);
    }

    /**
     * Buys points for a student.
     * 
     * @param studentIndex the index of the student
     * @param points the number of points to buy
     * @since 1.0
     */
    
    public void buyPoints(int studentIndex, int points) {
        Student student = customers.get(studentIndex);
        Account account = student.getAccount();
        if (account instanceof Alacarte) {
            ((Alacarte) account).buyPoints(points);
        }
    }

    /**
     * Lists all students.
     * 
     * @return string representation of students
     * @since 1.0
     * 
     */
    public String getStudentList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customers.size(); i++) {
            sb.append(i).append(") ").append(customers.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Lists all media.
     * 
     * @return string for media
     * @since 1.0
     * 
     */
    
    public String getMediaList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < library.size(); i++) {
            sb.append(i).append(") ").append(library.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
