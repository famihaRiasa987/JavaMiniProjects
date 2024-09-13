package test;
import customer.Student;
import product.Media;

public class TestStudent{
    public static void main(String args[]){
    boolean failed = false;
    Student studentObj = new Student("Famiha",1001981764, "fxr1764@mavs.uta.edu");
    if(!(studentObj.toString().equals("Famiha (1001981764,fxr1764@mavs.uta.edu, Account #1)"))){
        System.err.println("Fail: expected: Famiha (1001981764, fxr1764@mavs.uta.edu, Account #1)  actual: " + studentObj.toString());
        failed = true;
    
    }

    try{
            Student studentObj1 = new Student("Famiha", 1001981764, "fxr1764@gmail.com");
            System.err.println("FAIL: No exception thrown for invalid email");
            failed = true;
        }
        catch(IllegalArgumentException e){
            if (!e.getMessage().equals("Non-UTA email address: fxr1764@gmail.com")) {
                System.err.println("FAIL: Incorrect exception message. Expected: \"Non-UTA email address: fxr1764@gmail.com\" Actual: \"" + e.getMessage() + "\"");
                failed = true;
            }
        }
        catch(Exception e) {
            
            System.err.println("FAIL: Unexpected exception: " + e);
            failed = true;
        }
        try{
            Student studentObj2 = new Student("Famiha", 1001981764, "famiha.gmail.com");
            System.err.println("FAIL: No exception thrown for invalid email");
            failed = true;
        } 
        catch(IllegalArgumentException e){
            if (!e.getMessage().equals("Non-UTA email address: famiha.gmail.com")) {
                System.err.println("FAIL: Incorrect exception . Expected: \"Non-UTA email address: famiha.gmail.com\" Actual: \"" + e.getMessage() + "\"");
                failed = true;
            }
        } 
        catch(Exception e){
            System.err.println("FAIL: Unexpected exception: " + e);
            failed = true;
        }

        Media media = new Media("Title", "URL");
        Student studentObj3 = new Student("Famiha", 1001981764, "fxr1764@mavs.uta.edu"); 

        if(!(studentObj3.requestMedia(media).equals("Playing Title (URL)"))){
            System.err.println("FAIL: expected: Playing Title (URL) actual: " + studentObj3.requestMedia(media));
            failed = true;
        }


        if(failed){

            System.exit(1);
        }
        else 
        {
            System.exit(0);
                            
        }



    }


    }
    
