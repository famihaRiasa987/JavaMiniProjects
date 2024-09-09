public class TestMedia{
    public static void main(String args[]){

        Media media1 = new Media("Dog " ,"Dog.com");
        if(((media1.toString()).equals("Dog (Dog.com)"))==false){
            System.err.println("FAIL:  Expected String: Dog (Dog.com), Actual String: "+ media1.toString());
        }


        Media media2 = new Media("Dog " ,"");

        if(((media2.toString()).equals("Dog ())" ))==false){
            System.err.println("FAIL: missing URL. Expected String: Dog (), Actual String: "+ media2.toString());
        } 

        Media media3 = new Media("","(Dog.com)");
        
        if(((media3.toString()).equals(" (Dog.com)" ))==false){
            System.err.println("FAIL: missing title. Expected String: (Dog.com), Actual String: "+ media3.toString());
        } 


        Media media4 = new Media("","");
        
        if(((media4.toString()).equals("" ))==false){
            System.err.println("FAIL: missing title. Expected String: (Dog.com), Actual String: "+ media4.toString());
        } 



        }


}