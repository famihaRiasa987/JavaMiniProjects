package moes;

import product.Media;
import customer.Student;
import customer.Account;
import customer.Alacarte;
import customer.Unlimited;
import java.util.ArrayList;

public class MoesImpl implements Moes {
    private ArrayList<Media> media = new ArrayList<>();
    private ArrayList<Student> customers = new ArrayList<>();

    @Override
    public void addMedia(Media media) {
        this.media.add(media);
    }

    @Override
    public String getMediaList() {
        int index = 0;
        StringBuilder result = new StringBuilder();
        for (Media item : media) {
            result.append(index).append(") ").append(item.toString()).append("\n");
            index++;
        }
        return result.toString();
    }

    @Override
    public void addStudent(Student student) {
        this.customers.add(student);
    }

    @Override
    public String getStudentList() {
        int index = 0;
        StringBuilder result = new StringBuilder();
        for (Student item : customers) {
            result.append(index).append(") ").append(item.toString()).append("\n");
            index++;
        }
        return result.toString();
    }

    @Override
    public int getPoints(int studentIndex) {
        Account account = customers.get(studentIndex).getAccount();
        if (account instanceof Alacarte) {
            return ((Alacarte) account).getPointsRemaining();
        } else if (account instanceof Unlimited) {
            return Integer.MAX_VALUE;
        } else {
            throw new UnsupportedOperationException("Unknown subclass of Account");
        }
    }

    @Override
    public String buyPoints(int studentIndex, int points) {
        Account account = customers.get(studentIndex).getAccount();
        if (account instanceof Alacarte) {
            Alacarte alacarteAccount = (Alacarte) account;
            alacarteAccount.buyPoints(points);
            return "Student now has " + alacarteAccount.getPointsRemaining() + " points.";
        } else if (account instanceof Unlimited) {
            return "Student has an unlimited account and needs no additional points.";
        } else {
            throw new UnsupportedOperationException("Unknown subclass of Account");
        }
    }

    @Override
    public String playMedia(int studentIndex, int mediaIndex) {
        Student student = customers.get(studentIndex);
        Media media = this.media.get(mediaIndex);
        return student.requestMedia(media);
    }
}
