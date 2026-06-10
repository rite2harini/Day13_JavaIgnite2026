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
    private double balance;
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    // Synchronized method to ensure thread safety
    public synchronized void withdraw(double amount, String threadName) {
        System.out.printf("%-12s trying to withdraw: $%.2f | Current Balance: $%.2f%n", 
                         threadName, amount, balance);
        
        if(balance >= amount) {
            balance = balance - amount;
            System.out.printf("%-12s WITHDRAWAL SUCCESS: $%.2f | New Balance: $%.2f%n", 
                             threadName, amount, balance);
        } else {
            System.out.printf("%-12s WITHDRAWAL FAILED: Insufficient funds! Needed: $%.2f | Balance: $%.2f%n", 
                             threadName, amount, balance);
        }
        System.out.println("---------------------------------------------------");
    }
    
    // Synchronized method to ensure thread safety
    public synchronized void deposit(double amount, String threadName) {
        System.out.printf("%-12s trying to deposit: $%.2f | Current Balance: $%.2f%n", 
                         threadName, amount, balance);
        
        balance = balance + amount;
        System.out.printf("%-12s DEPOSIT SUCCESS: $%.2f | New Balance: $%.2f%n", 
                         threadName, amount, balance);
        System.out.println("---------------------------------------------------");
    }
    
    public double getBalance() {
        return balance;
    }
}

class WithdrawThread extends Thread {
    private BankAccount account;
    private Random random;
    
    public WithdrawThread(BankAccount account) {
        this.account = account;
        this.random = new Random();
    }
    
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            // Random amount between 500-2000
            double amount = 500 + random.nextInt(1501); // 500 to 2000
            
            account.withdraw(amount, "Thread-1(W)");
            
            try {
                // Small delay to simulate real transaction processing
                Thread.sleep(500 + random.nextInt(500));
            } catch(InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

class DepositThread extends Thread {
    private BankAccount account;
    private Random random;
    
    public DepositThread(BankAccount account) {
        this.account = account;
        this.random = new Random();
    }
    
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            // Random amount between 500-2000
            double amount = 500 + random.nextInt(1501); // 500 to 2000
            
            account.deposit(amount, "Thread-2(D)");
            
            try {
                // Small delay to simulate real transaction processing
                Thread.sleep(500 + random.nextInt(500));
            } catch(InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
        // Initial balance = $10,000
        BankAccount account = new BankAccount(10000);
        
        System.out.println("=== BANK TRANSACTION SYSTEM ===");
        System.out.printf("Initial Account Balance: $%.2f%n", account.getBalance());
        System.out.println("===================================================");
        System.out.println();
        
        // Create two threads operating on same account
        WithdrawThread thread1 = new WithdrawThread(account);
        DepositThread thread2 = new DepositThread(account);
        
        // Start both threads
        thread1.start();
        thread2.start();
        
        // Wait for both threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch(InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        System.out.println();
        System.out.println("===================================================");
        System.out.printf("FINAL ACCOUNT BALANCE: $%.2f%n", account.getBalance());
        System.out.println("All transactions completed successfully!");
    }
}
