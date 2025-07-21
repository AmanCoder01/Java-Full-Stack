package communicationwaitnotify;

class ThreadA extends Thread {
    int total = 0;

    @Override
    public void run() {
        System.out.println("Child thread starts calculation...");
        for (int i = 1; i <= 100; i++) {
            total += i;
        }

        synchronized (this) {
            System.out.println("Child thread giving notification...");
            this.notify();  // Notify the main thread
        }
    }
}

public class ThreadComm {
    public static void main(String[] args) {
        ThreadA a1 = new ThreadA();

        synchronized (a1) {
            a1.start();  // Start the child thread

            System.out.println("Main thread calling wait()");
            try {
                a1.wait();  // Wait for child thread to complete and notify
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Main thread got notified...");
            System.out.println("Total = " + a1.total);
        }
    }
}
