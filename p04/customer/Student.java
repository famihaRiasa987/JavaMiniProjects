package customer;

import product.Media;

public class Student {
    private String name;
    private int id;
    private String email;
    private Account account;

    public Student(String name, int id, String email) {
        if (!(email.endsWith("@mavs.uta.edu") || email.endsWith("@uta.edu"))) {
            throw new IllegalArgumentException("Non-UTA email address: " + email);
        }
        this.name = name;
        this.id = id;
        this.email = email;
        this.account = new Unlimited(); // Default to Unlimited account
    }

    public Account getAccount() {
        return account;
    }

    public String requestMedia(Media media) {
        return account.play(media);
    }

    @Override
    public String toString() {
        return this.name + " (" + this.id + ", " + this.email + ", Account #" + this.account.getAccountNumber() + ")";
    }
}
