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
package day13_progs;

class NumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

class EvenThread extends Thread {
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

class OddThread extends Thread {
    public void run() {
        for (int i = 1; i <= 9; i += 2) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

public class TaskScheduler {

    public static void main(String[] args) {

        NumberThread t1 = new NumberThread();
        EvenThread t2 = new EvenThread();
        OddThread t3 = new OddThread();

        t1.setName("Number Thread");
        t2.setName("Even Thread");
        t3.setName("Odd Thread");

        t1.start(); // I used start because it is showing error while using run() directly in main() . 
        t2.start();
        t3.start();
    }
}
