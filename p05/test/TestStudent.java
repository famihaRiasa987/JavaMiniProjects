package test;
import customer.Student;
import product.Media;

public class TestStudent {
    public static void main(String args[]) {
        boolean failed = false;

        // Creating a student with correct parameters
        Student studentObj = new Student("Famiha", 1001981764, "fxr1764@mavs.uta.edu", true); // Added boolean parameter
        if (!(studentObj.toString().equals("Famiha (1001981764, fxr1764@mavs.uta.edu, Account #1)"))) {
            System.err.println("Fail: expected: Famiha (1001981764, fxr1764@mavs.uta.edu, Account #1) actual: " + studentObj.toString());
            failed = true;
        }

        // Test with invalid email
        try {
            Student studentObj1 = new Student("Famiha", 1001981764, "fxr1764@gmail.com", true); // Added boolean parameter
            System.err.println("FAIL: No exception thrown for invalid email");
            failed = true;
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().equals("Non-UTA email address: fxr1764@gmail.com")) {
                System.err.println("FAIL: Incorrect exception message. Expected: \"Non-UTA email address: fxr1764@gmail.com\" Actual: \"" + e.getMessage() + "\"");
                failed = true;
            }
        } catch (Exception e) {
            System.err.println("FAIL: Unexpected exception: " + e);
            failed = true;
        }

        // Test with another invalid email
        try {
            Student studentObj2 = new Student("Famiha", 1001981764, "famiha.gmail.com", true); // Added boolean parameter
            System.err.println("FAIL: No exception thrown for invalid email");
            failed = true;
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().equals("Non-UTA email address: famiha.gmail.com")) {
                System.err.println("FAIL: Incorrect exception message. Expected: \"Non-UTA email address: famiha.gmail.com\" Actual: \"" + e.getMessage() + "\"");
                failed = true;
            }
        } catch (Exception e) {
            System.err.println("FAIL: Unexpected exception: " + e);
            failed = true;
        }

        // Media test
        Media media = new Media("Title", "URL", 9);
        Student studentObj3 = new Student("Famiha", 1001981764, "fxr1764@mavs.uta.edu", true); // Added boolean parameter

        if (!(studentObj3.requestMedia(media).equals("Playing Title (URL) 9"))) {
            System.err.println("FAIL: expected: Playing Title (URL) 9 actual: " + studentObj3.requestMedia(media));
            failed = true;
        }

        // Exit status based on test results
        if (failed) {
            System.exit(1);
        } else {
            System.exit(0);
        }
    }
}
