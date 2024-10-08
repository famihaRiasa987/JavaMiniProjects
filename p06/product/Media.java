package product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Media {
    private String title;
    private String url;
    private int points;

    public Media(String title, String url, int points) {
        this.title = title;
        this.url = url;
        this.points = points;
    }

    public Media(BufferedReader br) throws IOException {
        this.title = br.readLine();
        this.url = br.readLine();
        this.points = Integer.parseInt(br.readLine());
    }

    public void save(BufferedWriter bw) throws IOException {
        bw.write(title);
        bw.newLine();
        bw.write(url);
        bw.newLine();
        bw.write(String.valueOf(points));
        bw.newLine();
    }

    @Override
    public String toString() {
        return title + " (" + url + ") " + points + " points";
    }
}
