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
package java_internship_day13;

class Thread1 extends Thread {
    public void run() {
        setName("Thread-1");
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

class Thread2 extends Thread {
    public void run() {
        setName("Thread-2");
        for (int i = 2; i <= 10; i = i + 2) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

class Thread3 extends Thread {
    public void run() {
        setName("Thread-3");
        for (int i = 1; i <= 9; i = i + 2) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        Thread3 t3 = new Thread3();

        t1.start();
        t2.start();
        t3.start();
    }
}
