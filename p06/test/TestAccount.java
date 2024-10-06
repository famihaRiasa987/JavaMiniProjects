package test;
import product.Media;
import customer.Unlimited;
public class TestAccount{
 public static void main(String[] args) {
    boolean failed = false;
    Unlimited myaccount1 = new Unlimited();
    Unlimited myaccount2 = new Unlimited();

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