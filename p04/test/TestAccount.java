package test;
import customer.Account;
import product.Media;

public class TestAccount{
 public static void main(String[] args) {
    boolean failed = false;
    Account myaccount1 = new Account();
    Account myaccount2 = new Account();

    if(myaccount1.getAccountNumber()!=1 & myaccount2.getAccountNumber()!=2){
        System.err.println("Fail: Expected Account Numbers 1 and 2");
        System.err.println("Actual Account Numbers: "+ myaccount1.getAccountNumber()+" and"+ myaccount2.getAccountNumber());
        failed = true;
    }

    if(failed){
        System.exit(-1);
    }
    else{
        System.exit(0);
    }
    
}
}