package moes;

import customer.Account;
import customer.Alacarte;
import customer.Student;
import customer.Unlimited;
import product.Media;

import java.util.ArrayList;

/**
 * Implements the Moes interface to manage media and student data.
 * Handles adding students and media, managing points, and playing media.
 * 
 * @author Famiha Riasa
 * @version 0.2
 * @since 1.0
 */
public class MoesImpl implements Moes {
    private ArrayList<Media> library;
    private ArrayList<Student> customers;

    /**
     * Constructs a MoesImpl instance with empty lists for media and students.
     * 
     * @since 1.0
     */
    public MoesImpl() {
        library = new ArrayList<>();
        customers = new ArrayList<>();
    }

    /**
     * Adds a media item to the library.
     * 
     * @param media the Media object to add
     * @since 1.0
     */


    public void addMedia(Media media) {
        library.add(media);
    }

    /**
     * Adds a student to the system.
     * 
     * @param student the Student object to add
     * @since 1.0
     */

    public void addStudent(Student student) {
        customers.add(student);
    }

    /**
     * Returns the number of points for the student at the specified index.
     * 
     * @param studentIndex the index of the student
     * @return the number of points or Integer.MAX_VALUE for Unlimited accounts
     * @since 1.0
     */
 
    public int getPoints(int studentIndex) {
        Account account = customers.get(studentIndex).getAccount();
        if (account instanceof Alacarte) {
            return ((Alacarte) account).getPointsRemaining();
        }
        return Integer.MAX_VALUE; // Unlimited accounts have no point limit
    }

    /**
     * Plays the media for the student at the specified index.
     * 
     * @param studentIndex the index of the student
     * @param mediaIndex the index of the media
     * @return a message indicating the result of the play 
     * @since 1.0
     */
    @Override
    public String playMedia(int studentIndex, int mediaIndex) {
        Media media = library.get(mediaIndex);
        return customers.get(studentIndex).requestMedia(media);
    }

    /**
     * Buys points for the student at the specified index.
     * 
     * @param studentIndex the index of the student
     * @param points the number of points to buy
     * @since 1.0
     * 
     */
    public void buyPoints(int studentIndex, int points) {
        Student student = customers.get(studentIndex);
        Account account = student.getAccount();
        if (account instanceof Alacarte) {
            ((Alacarte) account).buyPoints(points);
        }
    }

    /**
     * Returns a string representation of all students in the system.
     * 
     * @return the string representation of students
     * @since 1.0
     */
    public String getStudentList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customers.size(); i++) {
            sb.append(i).append(") ").append(customers.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Returns a string representation of all media in the library.
     * 
     * @return the string representation of media
     * @since 1.0
     * 
     */
    @Override
    public String getMediaList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < library.size(); i++) {
            sb.append(i).append(") ").append(library.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}