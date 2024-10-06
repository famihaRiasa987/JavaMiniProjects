package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.Buffer;

import product.Media;

/**
 * Represents a student with an associated account.
 * This class manages the student's personal information and account interactions.
 * 
 * @author Famiha Riasa
 * @version 0.2
 * @since 1.0
 */
public class Student {
    private String name;
    private int id;
    private String email;
    private Account account;

    /**
     * Constructs a Student with the provided name, ID, and email.
     * Initializes the account based on the email domain.
     * 
     * @param name the student's name
     * @param id the student's ID
     * @param email the student's email address
     * @param isAlacarte sees if account is an Alacarte instance or not 

     * @since 1.0
     * 
     */
    public Student(String name, int id, String email, boolean isAlacarte) {
        this.name = name;
        this.id = id;
        this.email = email;
        if (isAlacarte) {
            this.account = new Alacarte();
        } else {
            this.account = new Unlimited();
        }
    }
    
    public Student(BufferedReader br) throws IOException{
        this.name = br.readLine();
        this.id = Integer.parseInt(br.readLine());
        this.email = br.readLine();
        String accountType = br.readLine();

        if("customer.Unlimited".equals(accountType)){
            this.account = new Unlimited(br);

        }
        else if("customer.Alacarte".equals(accountType)){
            this.account = new Alacarte(br);

        }
        else{
            throw new IllegalArgumentException("Wrong account type"+ accountType);

        }

    }
    public void save(BufferedWriter bw){
        bw.write(name);
        bw.newLine();
        bw.write(String.valueOf(id));
        bw.newLine();
        bw.write(email);
        bw.newLine();
        bw.write(account.getClass().getName()); 
        bw.newLine();
        account.save(bw);

        
    }




    /**
     * Returns the account associated with this student.
     * 
     * @return the Account object
     * @since 1.0
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Requests to play the specified media using the student's account.
     * 
     * @param media the Media object to be played
     * @return a message indicating the result of the play operation
     * @since 1.0
     */
    public String requestMedia(Media media) {
        return account.play(media);
    }

    /**
     * Returns a string representation of the student.
     * 
     * @return the string representation of the student
     * @since 1.0
     */
    @Override
    public String toString() {
        return this.name + " (" + this.id + ", " + this.email + ", Account #" + this.account.getAccountNumber() + ")";
    }
}
