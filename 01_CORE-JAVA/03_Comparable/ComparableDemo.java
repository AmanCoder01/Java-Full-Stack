import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {
    
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(4, "aman", 23, 10000));
        list.add(new Employee(20, "Vikas", 23, 10000));
        list.add(new Employee(9, "Sunny", 23, 10000));
        list.add(new Employee(1, "Vivek", 23, 10000));

        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
    }
}
