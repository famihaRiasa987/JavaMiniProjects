package moes;
import customer.Student;
import product.Media;

/**
 * Interface for managing students and media in the MOES system.
 * Provides methods to add students and media, manage points, and play media.
 * 
 * @author Famiha Riasa
 * @version 0.2
 * @since 1.0
 * 
 */
public interface Moes {
    /**
     * Adds a student to the system.
     * @param student the Student object to add
     * @since 1.0
     * 
     */
    void addStudent(Student student);

    /**
     * Adds media to the library.
     * @param media the Media object to add
     * @since 1.0
     */
    void addMedia(Media media);

    /**
     * Returns the number of points for the student at the specified index.
     * 
     * @param studentIndex the index of the student
     * @return the studentIndex
     * @since 1.0
     * 
     */
    int getPoints(int studentIndex);

    /**
     * Plays the media for the student at the specified index.
     * 
     * @param studentIndex the index of the student
     * @param mediaIndex the index of the media
     * @return studentIndex
     * @since 1.0
     * 
     */
    String playMedia(int studentIndex, int mediaIndex);

    /**
     * Buys points for the student at the specified index.
     * 
     * @param studentIndex the index of the student
     * @param points the number of points to buy
     * @since 1.0
     */
    void buyPoints(int studentIndex, int points);

    /**
     * Returns a string for student.
     * 
     * @return the string representation of students
     * @since 1.0
     */
    String getStudentList();

    /**
     * Returns a string of  media in the library.
     * 
     * @return the string of media
     * @since 1.0
     * 
     */
    String getMediaList();
}
