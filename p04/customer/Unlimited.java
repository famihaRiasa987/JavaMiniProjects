package customer;

import product.Media;

/**
 * Subclass Unlimited inherited from account.
 * This class allows playing media w/o (unlimited)any points.
 * 
 * @author Famiha Riasa
 * @version 0.2
 * @since 1.0
 * 
 */
public class Unlimited extends Account {

    /**
     * Constructs an Unlimited account.
     * 
     * @since 1.0
     */
    public Unlimited() {
    }

    /**
     * Plays media w/o requiring any points.
     * 
     * @param media the Media object to be played
     * @return a message indicating the media is being played
     * @since 1.0
     * 
     * 
     */
    @Override
    public String play(Media media) {
        return "Playing " + media.toString();
    }
}
