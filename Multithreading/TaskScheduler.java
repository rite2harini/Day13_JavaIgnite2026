// Thread 1: Prints numbers 1 to 5
class NumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

// Thread 2: Prints even numbers 2 to 10
class EvenThread extends Thread {
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

// Thread 3: Prints odd numbers 1 to 9
class OddThread extends Thread {
    public void run() {
        for (int i = 1; i <= 9; i += 2) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

// Main Class
public class MultiThreadDemo {
    public static void main(String[] args) {

        NumberThread t1 = new NumberThread();
        EvenThread t2 = new EvenThread();
        OddThread t3 = new OddThread();

        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
    }
}/*
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
