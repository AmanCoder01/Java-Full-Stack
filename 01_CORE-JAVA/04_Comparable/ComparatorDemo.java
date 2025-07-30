import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorDemo {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(4, "Aman", 23, 10000));
        list.add(new Employee(20, "Aman", 20, 10000));
        list.add(new Employee(9, "Sunny", 23, 10000));
        list.add(new Employee(1, "Vivek", 23, 10000));

        System.out.println(list);

        Collections.sort(list, new NameAgeComparator());
        System.out.println(list);
    }
}
