public class Purse {
    public static void main(String[] args) {
        Coin[] purse = new Coin[5];
        purse[0] = new Coin(Denomination.PENNY, 1900);
        purse[1] = new Coin(Denomination.DIME, 1860);
        purse[2] = new Coin(Denomination.NICKEL, 1950);
        purse[3] = new Coin(Denomination.PENNY, 1980);
        purse[4] = new Coin(Denomination.QUARTER, 1880);

        double totalValue = 0.0;
        double totalWeight = 0.0;
        int earliestYear = Integer.MAX_VALUE;
        int latestYear = Integer.MIN_VALUE;

        for (Coin coin : purse) {
            System.out.println(coin);

            totalValue += coin.getValue();
            totalWeight += coin.getWeight();

            int year = coin.getYear();
            if (year < earliestYear){
                earliestYear = year;
            }
            if (year > latestYear){
                latestYear = year;
            }
        }
        System.out.println("You have $" + String.format("%.2f", totalValue));
        System.out.println("Earliest year is: " + earliestYear + " to latest year is: " + latestYear+" weighing"+ String.format("%.3f", totalWeight) + " grams");
    }
}
