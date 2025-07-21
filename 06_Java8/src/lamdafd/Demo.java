package lamdafd;

@FunctionalInterface
interface Inter{
    void m1();
}

class Child implements Inter{

    @Override
    public void m1() {
        System.out.println("Hey m1");
    }
}
public class Demo {
    public static void main(String[] args) {
//        Child c = new Child();
//        c.m1();

        // lambda exp
        Inter i = ()-> System.out.println("Hey");
        i.m1();
    }
}
