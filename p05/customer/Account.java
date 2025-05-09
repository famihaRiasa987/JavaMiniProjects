package customer;

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
