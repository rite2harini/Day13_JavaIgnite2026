/*
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

import java.util.Random;

class BankAccount {
    int balance = 10000;
    synchronized void withdraw(int amt) {
        if (balance - amt < 0) {
            System.out.println("Withdrawal of " + amt + " skipped (insufficient funds) | Balance: " + balance);
            return;
        }
        balance -= amt;
        System.out.println("Withdrew: " + amt + " | Balance: " + balance);
    }

    synchronized void deposit(int amt) {
        balance += amt;
        System.out.println("Deposited: " + amt + " | Balance: " + balance);
    }
}
public class Banking_Transaction_Simulation {
    public static void main(String[] args) throws InterruptedException {
        BankAccount acc = new BankAccount();
        Random r = new Random();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                int amt = 500 + r.nextInt(1501);
                acc.withdraw(amt);
                try { Thread.sleep(100); } catch (Exception e) {}
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                int amt = 500 + r.nextInt(1501);
                acc.deposit(amt);
                try { Thread.sleep(100); } catch (Exception e) {}
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("\nFinal balance: " + acc.balance);
    }
}
