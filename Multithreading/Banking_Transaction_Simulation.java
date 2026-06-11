import java.util.Random;

// Shared Account Class
class BankAccount {
    private int balance = 10000;

    // Synchronized withdrawal method
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(
                Thread.currentThread().getName()
                + " Withdrawn: ₹" + amount
                + " | Balance: ₹" + balance
            );
        } else {
            System.out.println(
                Thread.currentThread().getName()
                + " Withdrawal of ₹" + amount
                + " Failed (Insufficient Balance)"
                + " | Balance: ₹" + balance
            );
        }
    }

    // Synchronized deposit method
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(
            Thread.currentThread().getName()
            + " Deposited: ₹" + amount
            + " | Balance: ₹" + balance
        );
    }
}

// Withdrawal Thread
class WithdrawalThread extends Thread {
    private BankAccount account;
    private Random random = new Random();

    public WithdrawalThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            int amount = random.nextInt(1501) + 500; // 500–2000
            account.withdraw(amount);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Deposit Thread
class DepositThread extends Thread {
    private BankAccount account;
    private Random random = new Random();

    public DepositThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            int amount = random.nextInt(1501) + 500; // 500–2000
            account.deposit(amount);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main Class
public class BankSystem {
    public static void main(String[] args) {

        // Shared account
        BankAccount account = new BankAccount();

        // Create threads
        WithdrawalThread thread1 = new WithdrawalThread(account);
        DepositThread thread2 = new DepositThread(account);

        thread1.setName("Thread-Withdraw");
        thread2.setName("Thread-Deposit");

        // Start threads
        thread1.start();
        thread2.start();
    }
}/*
Create a Java program to simulate a bank system with a shared account balance.

Task:
Initial account balance = 10,000
Create two threads:
Thread 1 → performs 5 withdrawals (random amounts between 500–2000)
Thread 2 → performs 5 deposits (random amounts between 500–2000)
Requirements:
Both threads should operate on the same account balance
Print updated balance after every transaction
Ensure balance never goes negative
Hint:

Think step-by-step:

Shared resource = balance variable
Use synchronization concept (important idea: avoid race condition)
Each thread modifies same data
Control access carefully
*/
