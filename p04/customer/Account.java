package customer;

import product.Media;

public abstract class Account {
    private int accountNumber;
    private static int nextAccountNumber = 1;

    public Account() {
        this.accountNumber = nextAccountNumber;
        nextAccountNumber++;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public abstract String play(Media media);
}
