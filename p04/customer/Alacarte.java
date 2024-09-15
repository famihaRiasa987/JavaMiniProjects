package customer;

import product.Media;

/**
 * Represents an account with a specific number of points.
 * This class allows playing media based on the points available in the account.
 * 
 * @author Famiha Riasa
 * @version 0.2
 * @since 1.0
 */
public class Alacarte extends Account {
    private int pointsRemaining;

    /**
     * Constructs an Alacarte account with zero initial points.
     * 
     * @since 1.0
     */
    public Alacarte() {
        this.pointsRemaining = 0;
    }

    /**
     * Adds points to the account.
     * 
     * @param points the number of points to add
     * @since 1.0
     */
    public void buyPoints(int points) {
        this.pointsRemaining += points;
    }

    /**
     * Returns the number of points remaining in the account.
     * 
     * @return the number of points remaining
     * @since 1.0
     */
    public int getPointsRemaining() {
        return this.pointsRemaining;
    }

    /**
     * Plays the specified media if enough points are available.
     * 
     * @param media the Media object to be played
     * @return a message indicating whether the media is played or more points are needed
     * @since 1.0
     */
    @Override
    public String play(Media media) {
        if (pointsRemaining >= media.getPoints()) {
            pointsRemaining -= media.getPoints();
            return "Playing " + media.toString();
        } else {
            return "Buy more points: Requires " + media.getPoints() + " points, you have " + pointsRemaining;
        }
    }
}
