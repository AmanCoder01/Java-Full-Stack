package lockdemo;

public class Driver {
    public static void main(String[] args) {
        // Shared bank account object
        BankAccount account = new BankAccount();

        // Two withdrawal operations on the same account
        Runnable t1 = () -> account.withdraw("Wife", 200); // Will fail
        Runnable t2 = () -> account.withdraw("Papa", 500);   // Will succeed

        // Start both threads
        new Thread(t1).start();
        new Thread(t2).start();
    }
}
