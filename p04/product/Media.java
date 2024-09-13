package product;


public class Media{
    private String title;
    private String url;
    private int points;

    public Media(String title, String url, int points){
        this.title = title;
        this.url = url;
        this.points = points;
        }
    public int getPoints(){
        return this.points;
    }

    @Override
    public String toString(){
        return this.title + " ("+ this.url + ") "+ this.points;
    }
    
}