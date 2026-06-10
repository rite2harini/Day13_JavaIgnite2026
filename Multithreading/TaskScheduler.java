class NumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);

            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }
    }
}

class EvenThread extends Thread {
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(Thread.currentThread().getName() + " : " + i);

            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }
    }
}

class OddThread extends Thread {
    public void run() {
        for (int i = 1; i <= 9; i += 2) {
            System.out.println(Thread.currentThread().getName() + " : " + i);

            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
        }
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {

        NumberThread t1 = new NumberThread();
        EvenThread t2 = new EvenThread();
        OddThread t3 = new OddThread();

        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
