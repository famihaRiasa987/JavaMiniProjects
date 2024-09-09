public class Account{
    private int accountNumber;
    private static int nextAccountNumber = 1; 

    public Account(){
        private int account_number;
        this.nextAccountNumber = account_number;
        account_number++;
    }
    public int getAccountNumber(){
        return this.account_number;
    }

    public String play(Media media){

        return "Playing "+ media.toString();
    }
}