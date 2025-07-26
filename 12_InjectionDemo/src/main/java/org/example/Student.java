package org.example;

public class Student {
    private Course course;

    //dependency injection

    //constructor injection


    public Student(Course course) {
        this.course = course;
    }

    //setter injection
    public void setCourse(Course course) {
        this.course = course;
    }

    public void study(){
        int start = course.enroll();

        if(start>=1){
            System.out.println("Journey started...");
        }else{
            System.out.println("Payment failed");
        }
    }
}
