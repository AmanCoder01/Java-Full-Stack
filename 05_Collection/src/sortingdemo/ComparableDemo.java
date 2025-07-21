package sortingdemo;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(34);
        list.add(4);
        list.add(33);

        list.add(7);
        list.add(88);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);


        ArrayList<Student> arrayList = new ArrayList<>();
        Student s1 = new Student(11,"Aman");
        Student s2 = new Student(1,"Raj");
        Student s3 = new Student(88,"Shivam");

        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);

        System.out.println(arrayList);

        Collections.sort(arrayList);

        System.out.println(arrayList);


        ArrayList<Employee> al = new ArrayList<>();
        Employee  e1 = new Employee(11,"Aman","sci");
        Employee  e2 = new Employee(1,"Aman","sci");
        Employee  e3 = new Employee(165,"Rah","sci");

        al.add(e1);
        al.add(e2);
        al.add(e3);

        System.out.println(al);
        Collections.sort(al,new Employee());
        System.out.println(al);


    }
}
