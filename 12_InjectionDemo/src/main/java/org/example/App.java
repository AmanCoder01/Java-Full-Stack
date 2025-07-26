package org.example;

public class App {
    public static void main(String[] args) {
        Course  course = new DSA();
        Student s= new Student(course);


        s.setCourse(course);
        s.study();
    }
}
