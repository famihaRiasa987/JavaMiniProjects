package test;

import product.Media;


public class TestMedia {
  
    public static void main(String[] args) {
        boolean failed = false; 

        Media media1 = new Media("Dog", "Dog.com",3);
        if (!media1.toString().equals("Dog (Dog.com)")) {
            System.err.println("FAIL: Expected String: Dog (Dog.com), Actual String: " + media1.toString());
            failed = true; 
        }

        Media media2 = new Media("Dog", "",4);
        if (!media2.toString().equals("Dog ()")) {
            System.err.println("FAIL: Missing URL. Expected String: Dog (), Actual String: " + media2.toString());
            failed = true; 
        }

        Media media3 = new Media("", "Dog.com",5);
        if (!media3.toString().equals(" (Dog.com)")) {
            System.err.println("FAIL: Missing title. Expected String:  (Dog.com), Actual String: " + media3.toString());
            failed = true; 
        }

        Media media4 = new Media("", "",6);
        if (!media4.toString().equals(" ()")) {
            System.err.println("FAIL: Missing title and URL. Expected String:  (), Actual String: " + media4.toString());
            failed = true; 
        }
        if (failed) {
            System.exit(-1); 
        }
        System.exit(0);
    }
}
