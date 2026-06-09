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
package day13_progs;

import java.util.Random;

class BankAccount {
    private int balance = 10000;

    public synchronized void deposit(int amount) {//for input
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited ₹" + amount+ " | Balance = ₹" + balance);
    }

    public synchronized void withdraw(int amount) {//for output
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName()+ " withdrew ₹" + amount+ " | Balance = ₹" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to withdraw ₹" + amount+ " | Insufficient Balance");
        }
    }
}

class DepositTask implements Runnable {
    BankAccount account;// a reference variable
    Random rand = new Random();//to randomly generate

    DepositTask(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            int amount = rand.nextInt(1451) + 500;//random print
            account.deposit(amount);
        }
    }
}

class WithdrawTask implements Runnable {//similarly changing name to withdraw
    BankAccount account;
    Random rand = new Random();

    WithdrawTask(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            int amount = rand.nextInt(1451) + 500;
            account.withdraw(amount);
        }
    }
}

public class Banking_Transaction_Simulation {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(new WithdrawTask(account), "Withdraw Thread");
        Thread t2 = new Thread(new DepositTask(account), "Deposit Thread");

        t1.start();
        t2.start();
    }
}
