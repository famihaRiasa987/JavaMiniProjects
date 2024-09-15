package moes;

import product.Media;
import customer.Student;

public interface Moes {
    void addMedia(Media media);
    String getMediaList();
    void addStudent(Student student);
    String getStudentList();
    int getPoints(int studentIndex);
    String buyPoints(int studentIndex, int points);
    String playMedia(int studentIndex, int mediaIndex);
}
