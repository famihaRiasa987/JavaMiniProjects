package customer;
import product.Media;

abstract class Account{
    private int accountNumber;
    private static int nextAccountNumber = 1; 

    public Account(){
        this.accountNumber = nextAccountNumber;
        nextAccountNumber++;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }

    abstract String play(Media media);


}