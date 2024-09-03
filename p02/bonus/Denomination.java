public enum Denomination{
    PENNY,
    NICKEL,
    DIME,
    QUARTER;

    private final double value;
    public double getValue(){
        return value;

    }
    public String toString(){
        return name().toLowerCase();
    }
    private Denomination(double value){
        this.value = value;
    }
    
}