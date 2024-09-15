package customer;

import product.Media;

/**
 * Represents a student class.
 * This class manages the students personal info and requesting media.
 * 
 * @author Famiha Riasa
 * @version 0.2
 * @since 1.0
 * 
 */
public class Student {
    private String name;
    private int id;
    private String email;
    private Account account;

    /**
     * Constructs Student: 
     * Initializes the account 
     * @param name  student's name
     * @param id  student's ID
     * @param email  student's email address
     * @since 1.0
     * 
     */

    public Student(String name, int id, String email) {
        if (!(email.endsWith("@mavs.uta.edu") || email.endsWith("@uta.edu"))) {
            throw new IllegalArgumentException("Non-UTA email address: " + email);
        }
        this.name = name;
        this.id = id;
        this.email = email;
        this.account = new Unlimited();
    }

    /**
     * Returns the account of this student.
     * 
     * @return Account account object
     * @since 1.0
     * 
     */
    public Account getAccount() {
        return account;
    }

    /**
     * play the  media using the student's account.
     * 
     * @param media play the Media object 
     * @return the result of play 
     * @since 1.0
     * 
     */
    public String requestMedia(Media media) {
        return account.play(media);
    }

    /**
     * Returns a string representation of student.
     * @return the String student
     * @since 1.0
     * 
     */
    @Override
    public String toString() {
        return this.name + " (" + this.id + ", " + this.email + ", Account #" + this.account.getAccountNumber() + ")";
    }
}
