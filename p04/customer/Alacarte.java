package customer;
import product.Media;

public class Alacarte extends Account{
    
    private int pointsRemaining;

    public Alacarte(int pointsRemaining){
        this.pointsRemaining = pointsRemaining;

    }

    public void buyPoints(int points){
        this.pointsRemaining += points;
    }

    public int getPointsRemaining(){
        return this.pointsRemaining;
    }

   // @Override
    public String play(Media media){
        if(this.pointsRemaining>media.getPoints()){
            return "Playing ";
        }
        else{
            return "Buy more points: Requires ";
        }
    }                    




}