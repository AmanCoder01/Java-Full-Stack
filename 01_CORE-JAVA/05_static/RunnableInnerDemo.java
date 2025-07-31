public class RunnableInnerDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1");
            }
        });

        t.start();
        t.join();

        System.out.println("Main Thread");

    }

}