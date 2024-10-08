package customer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import product.Media;

public class Student {
    private String name;
    private int id;
    private String email;
    private Account account;

    public Student(String name, int id, String email, boolean isAlacarte) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.account = isAlacarte ? new Alacarte() : new Unlimited();
    }

    // Constructor to load from file
    public Student(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.id = Integer.parseInt(br.readLine());
        this.email = br.readLine();
        String accountType = br.readLine();

        if (accountType.equals("customer.Alacarte")) {
            this.account = new Alacarte(br);
        } else if (accountType.equals("customer.Unlimited")) {
            this.account = new Unlimited(br);
        } else {
            throw new IOException("Unknown account type: " + accountType);
        }
    }

    // New method to handle media requests
    public String requestMedia(Media media) {
        return "Student " + name + " is playing media: " + media.toString();
    }

    // Save method to write to file
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name);
        bw.newLine();
        bw.write(String.valueOf(id));
        bw.newLine();
        bw.write(email);
        bw.newLine();
        bw.write(account.getClass().getName());
        bw.newLine();
        account.save(bw); // Save account details
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return name + " (" + id + ", " + email + ", Account #" + account.getAccountNumber() + ")";
    }
}
