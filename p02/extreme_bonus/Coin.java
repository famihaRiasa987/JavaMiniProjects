public class Coin{

    private Denomination denomination;
    private int year;

    public Coin(Denomination denomination, int year){
        this.denomination = denomination;
        this.year = year;
    }
    public double getValue() {
        return denomination.getValue();  
    }
    public double getWeight(){
        if(denomination == Denomination.PENNY){
            if(year < 1983){
                return 3.110;
            } 
            else{
                return 2.500;
            }
        }
        else if(denomination == Denomination.NICKEL){
            return 5.000;
            }
        else if(denomination == Denomination.DIME){
            if (year < 1965) {
                return 2.500;
            }
            else{
                return 2.268;
            }
        } 
        else if (denomination == Denomination.QUARTER) {
            if (year < 1965) {
                return 6.250;
            }
            else{
                return 5.670;
            }
        }
        else{
            throw new IllegalArgumentException("Unknown denomination: " + denomination);
        }
    }
    public String toString() {
        return "Year: " + year + ", Denomination: " + denomination.toString();
    }
    public int getYear() {
        return year;
    }
}
