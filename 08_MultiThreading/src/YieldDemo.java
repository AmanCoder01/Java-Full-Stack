class YieldThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " --- " + i);

            // Yield gives a hint to the thread scheduler that the current thread is willing to pause
            Thread.yield();
        }
    }
}

public class YieldDemo {
    public static void main(String[] args) {
        YieldThread t1 = new YieldThread();
        YieldThread t2 = new YieldThread();

        t1.setName("T1");
        t2.setName("T2");

        t1.start();
        t2.start();

        // Optional: Let main thread also do some work
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " --- " + i);
            Thread.yield(); // even main thread can yield
        }
    }
}
