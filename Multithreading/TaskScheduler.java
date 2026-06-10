/*
Create a program with 3 threads:

Thread 1 → prints numbers 1–5
Thread 2 → prints even numbers 2–10
Thread 3 → prints odd numbers 1–9
Task:
Ensure all threads run independently
Print thread name with each output
Hint:

Think:

Each thread = separate class OR Runnable
Use run() method logic
Focus on parallel execution behavior
*/
// Thread 1: Prints numbers 1-5
class NumberThread extends Thread {
    public NumberThread() {
        super("NumberThread");
    }
    
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " -> " + i);
            try {
                Thread.sleep(300);
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

// Thread 2: Prints even numbers 2-10
class EvenThread extends Thread {
    public EvenThread() {
        super("EvenThread");
    }
    
    @Override
    public void run() {
        for(int i = 2; i <= 10; i = i + 2) {
            System.out.println(Thread.currentThread().getName() + " -> " + i);
            try {
                Thread.sleep(400);
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

// Thread 3: Prints odd numbers 1-9
class OddThread extends Thread {
    public OddThread() {
        super("OddThread");
    }
    
    @Override
    public void run() {
        for(int i = 1; i <= 9; i = i + 2) {
            System.out.println(Thread.currentThread().getName() + " -> " + i);
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        System.out.println("=== 3 THREADS RUNNING INDEPENDENTLY ===");
        System.out.println("Main Thread: " + Thread.currentThread().getName());
        System.out.println("----------------------------------------");
        
        // Create thread instances
        NumberThread thread1 = new NumberThread();
        EvenThread thread2 = new EvenThread();
        OddThread thread3 = new OddThread();
        
        // Start all threads
        thread1.start();
        thread2.start();
        thread3.start();
        
        // Wait for all threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch(InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        
        System.out.println("----------------------------------------");
        System.out.println("All threads completed!");
    }
}
