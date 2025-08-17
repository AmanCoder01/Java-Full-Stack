package synchronized_demo;

public class Test implements Runnable{

    Hello hello;

    public Test(Hello hello) {
        this.hello = hello;
    }

    @Override
    public void run() {
        hello.addition();
        System.out.println(hello.getSum());
    }

    public static void main(String[] args) {
        Hello h1 = new Hello();

        Thread thread = new Thread(new Test(h1));
        thread.setName("First Thread");
        Thread thread2 = new Thread(new Test(h1));
        thread2.setName("Second Thread");

        thread.start();
        thread2.start();
    }
}
