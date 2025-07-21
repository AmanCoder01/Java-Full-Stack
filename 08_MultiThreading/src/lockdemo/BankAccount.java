package lockdemo;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    // Initial balance
    int bal = 1000;

    // Lock object to control access
    final ReentrantLock reentrantLock = new ReentrantLock();

    // Method to withdraw money with thread safety
    public void withdraw(String name, int amount) {
        // Acquire the lock before accessing shared resource
        reentrantLock.lock();

        try {
            System.out.println(name + " is trying to withdraw: " + amount);

            // Simulate some processing time
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {

            }

            // Check for sufficient balance
            if (amount <= bal) {
                bal -= amount;
                System.out.println(name + " successfully withdrew " + amount + ". Remaining balance: " + bal);
            } else {
                System.out.println(name + " failed to withdraw. Insufficient Balance.");
            }

        } finally {
            // Always release the lock
            reentrantLock.unlock();
        }
    }
}
