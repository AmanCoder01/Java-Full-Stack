package lamdafd;

@FunctionalInterface
interface InterF{
      void sum(int a,int b);
}

public class AdditionTwoNum {
    public static void main(String[] args) {
        InterF i = (a,b)-> {
            System.out.println(a+b);
        };

        i.sum(2,3);
    }
}
