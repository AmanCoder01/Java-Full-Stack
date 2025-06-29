package predicatedemo;


import java.util.function.Predicate;

public class Demo {
    public static void m1(Predicate<Integer> p,int []arr){
        for(int i:arr){
            if(p.test(i)){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Predicate<Integer> p = (num) -> num>10;
        System.out.println(p.test(9));

        Predicate<String> p1= (s) -> s.length()>3;
        System.out.println(p1.test("Aman"));

        int arr[] = {1,2,3,4,5};
        Predicate<Integer> p2 = i -> i%2==0;
        Predicate<Integer> p3 = i -> i>2;

        System.out.println("Print all even numbers");
        m1(p2,arr);

        System.out.println("Print all  numbers greater than 2");
        m1(p3,arr);

        System.out.println("Print all  numbers greater than 2 and even");
        m1(p3.and(p2),arr);

        System.out.println("Print all  odd numbers");
        m1(p2.negate(),arr);




    }
}
