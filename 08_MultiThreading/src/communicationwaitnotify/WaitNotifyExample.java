package communicationwaitnotify;

class SharedQueue{
    private int item;
    private boolean available = false;

    // Producer method
    public synchronized void  produce(int value){
        while (available) {
            try {
                wait(); // Wait until item is consumed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        item = value;
        System.out.println("Produced: " + item);
        available = true;
        notify(); // Notify the consumer
    }

    // Consumer method
    public synchronized void consume() {
        while (!available) {
            try {
                wait(); // Wait until item is produced
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Consumed: " + item);
        available = false;
        notify(); // Notify the producer
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        SharedQueue queue = new SharedQueue();

        // Producer thread
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                queue.produce(i);
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                queue.consume();
            }
        });

        producer.start();
        consumer.start();
    }
}
