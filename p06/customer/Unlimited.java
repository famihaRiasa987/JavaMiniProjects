package customer;

import product.Media;

/**
 * Represents an account with unlimited access to media.
 * This class allows playing media without any points requirement.
 * 
 * @author Famiha Riasa
 * @version 0.2
 * @since 1.0
 */
public class Unlimited extends Account {

    /**
     * Constructs an Unlimited account.
     * Calls the default constructor of the superclass.
     * 
     * @since 1.0
     */
    public Unlimited() {
        // Default constructor
    }

    /**
     * Plays the specified media without requiring any points.
     * 
     * @param media the Media object to be played
     * @return a message indicating the media is being played
     * @since 1.0
     */
    @Override
    public String play(Media media) {
        return "Playing " + media.toString(); // No points required for Unlimited accounts
    }
}
