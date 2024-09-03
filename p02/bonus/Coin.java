enum Denomination{
    PENNY,
    NICKEL,
    DIME,
    QUARTER;

    private final double value;
    public double getValue(){

    }
    public String toString(){

    }
    private Denomination(double value){
        this.value = value;
    }
    
}
public class Coin{
    private Denomination denomination;
    private int year;
    

    public Coin(Denomination denomination, int year){
        this.denomination = denomination;  
        this.year = year;
    }

   public double getValue(){
    return switch(denomination){
        case PENNY -> 0.01;
        case NICKEL -> 0.05;
        case DIME -> 0.10;
        case QUARTER -> 0.25;
    };
    
}

    public int getYear(){
        return year;
    }
    }
class Purse{
    public static void main(String[] args){
        Coin[] purse = new Coin[5];
        purse[0] = new Coin(Denomination.PENNY, 1900);
        purse[1] = new Coin(Denomination.DIME, 1860);
        purse[2] = new Coin(Denomination.NICKEL, 1950);
        purse[3] = new Coin(Denomination.PENNY, 1980);
        purse[4] = new Coin(Denomination.QUARTER, 1880);
        double totalValue = 0.0;
        int earliestYear = Integer.MAX_VALUE;
        int latestYear = Integer.MIN_VALUE;
        for(Coin coin : purse){

            totalValue += coin.getValue();
            int year = coin.getYear();

            if (year < earliestYear)
            {
                earliestYear = year;
            }
            if (year > latestYear)
            {
                latestYear = year;
            }
        }

        System.out.println("You have: $" + String.format("%.2f",totalValue)+ " coins");
        System.out.println("Earliest year is : " + earliestYear + " to latest year is: " + latestYear);
    }

}


