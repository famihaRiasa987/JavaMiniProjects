package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

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
        super();
    }
    public Unlimited(BufferedReader br) throws IOException{
        super(br);

    }
    public void save(BufferedWriter bw) throws IOException
    {
        super.save(bw);
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
