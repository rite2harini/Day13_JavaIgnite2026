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


class T1 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " -> " + i);
        }
    }
}

class T2 extends Thread {
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(getName() + " -> " + i);
        }
    }
}
class T3 extends Thread {
    public void run() {
        for (int i = 1; i <= 9; i += 2) {
            System.out.println(getName() + " -> " + i);
        }
    }
}
public class TaskScheduler {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        T3 t3 = new T3();
        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");
        t1.start();
        t2.start();
        t3.start();
    }
}