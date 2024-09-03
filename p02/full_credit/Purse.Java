class Purse{
    public static void main(String[] args){
        Coin[] purse = new Coin[5];
        purse[0] = new Coin(Denomination.PENNY, 1850);
        purse[1] = new Coin(Denomination.DIME, 1750);
        purse[2] = new Coin(Denomination.NICKEL, 1920);
        purse[3] = new Coin(Denomination.PENNY, 1945);
        purse[4] = new Coin(Denomination.QUARTER, 1980);
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