package defaultmethod;

interface In{
    default void m1(){
        System.out.println("m1()");
    }
}

public class DefaultMethod implements In{

    public void m1(){
        System.out.println("m1() in Child");
    }

    public static void main(String[] args) {
        DefaultMethod defaultMethod = new DefaultMethod();
        defaultMethod.m1();
    }
}
