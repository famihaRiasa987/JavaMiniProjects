package product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
/**
 * Represents a media item with a title, URL, and points required to access it.
 * Provides details about the media and the points required.
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
     * Constructs a Media object with the specified title, URL, and points.
     * 
     * @param title the title of the media
     * @param url the URL of the media
     * @param points the points required to access the media
     * @since 1.0
     */
    public Media(String title, String url, int points) {
        this.title = title;
        this.url = url;
        this.points = points;
    }
    public Media(BufferedReader br) throws IOException{
    // read the save method 
    this.title = br.readLine();
    this.url = br.readLine();
    this.points =Integer.parseInt(br.readLine());



    }
    public void save(BufferedWriter bw) throws IOException{

        bw.write(title);
        bw.newLine();
        bw.write(url);
        bw.newLine();
        bw.write(String.valueOf(points));
        bw.newLine();

    }

    /**
     * Returns the title of the media.
     * 
     * @return the title of the media
     * @since 1.0
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the URL of the media.
     * 
     * @return the URL of the media
     * @since 1.0
     */
    public String getUrl() {
        return url;
    }

    /**
     * Returns the points required to access the media.
     * 
     * @return the points required
     * @since 1.0
     */
    public int getPoints() {
        return points;
    }

    /**
     * Returns a string representation of the media, including its title and URL.
     * 
     * @return the string representation of the media
     * @since 1.0
     */
    @Override
    public String toString() {
        return title + " (" + url + ") " + points;
    }
}
