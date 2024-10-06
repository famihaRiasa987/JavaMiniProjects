package customer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import product.Media;

/**
 * Abstract class representing a user account.
 * This class provides the account number and abstract method to play media.
 * 
 * @author Famiha Riasa
 * @version 0.2
 * @since 1.0
 */
public abstract class Account {
    private int accountNumber;
    private static int nextAccountNumber = 1;

    /**
     * Constructs an Account with a unique account number.
     * Increments the account number counter for future instances.
     * 
     * @since 1.0
     */
    public Account() {
        this.accountNumber = nextAccountNumber;
        nextAccountNumber++;
    }
    public Account(BufferedReader br) throws IOException{
        this.accountNumber = Integer.parseInt(br.readLine());
        nextAccountNumber = Integer.parseInt(br.readLine());
    }
    public void save(BufferedWriter bw) throws IOException{

        bw.write(String.valueOf(accountNumber));
        bw.newLine();
        bw.write(String.valueOf(nextAccountNumber));
        bw.newLine();

    }
    /**
     * Returns the account number of this account.
     * 
     * @return the account number
     * @since 1.0
     */
    public int getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * Abstract method to play media. Each subclass must provide an implementation.
     * 
     * @param media the Media object to be played
     * @return a message indicating the result of the play operation
     * @since 1.0
     */
    public abstract String play(Media media);
}
