public class Hello {
    public static void main(String[] args) {
        String nameOfUser = System.getProperty("user.name");

        System.out.println("Hello, " + nameOfUser + "!");
    }
}
