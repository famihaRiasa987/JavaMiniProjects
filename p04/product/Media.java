package product;

/**
 * Media class : a title, URL, and associated points.
 * This class provides methods to retrieve the points required to purchase media entertainment  and a string representation of the media.
 * 
 * @author Famiha Riasa
 * @version 0.2
 * @since 1.0
 * 
 */ 
public class Media {
    private String title;
    private String url;
    private int points;

    /**
     * Creates a Media instance.
     * 
     * @param title the string title of the media
     * @param url the string URL of the media
     * @param points the integer points required to purchase the media
     * @since 1.0
     * 
     */ 

    public Media(String title, String url, int points) {
        this.title = title;
        this.url = url;
        this.points = points;
    }

    /**
     * 
     * Returns the number of points required to purchase this media item.
     * 
     * @return the number of points needed
     * @since 1.0
     * 
     */ 

    public int getPoints() {
        return this.points;
    }

    /**
     * Returns a string representation of the media item, including its title, URL, and points.
     * 
     * @return the string representation of the media item
     * @since 1.0
     * 
     */ 
    @Override
    public String toString() {
        return this.title + " (" + this.url + ") " + this.points;
    }
}
