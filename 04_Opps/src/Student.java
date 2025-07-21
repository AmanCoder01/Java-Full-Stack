public class Student {
    String name;
    int rollno;

    Student(){
        this("Unknown",0);
    }

    Student(String name,int rollno){
        this.name = name;
        this.rollno = rollno;
    }

    void display(){
        System.out.println("Name "+ name + " Rollno "+rollno);
        print(this);
    }

    void print(Student s){
        System.out.println("Hello "+s.name);
    }

    public static void main(String[] args) {
       Student s1 = new Student();


        Student s2 = new Student("Aman",24);
        s1.display();
        s2.display();
    }
}
