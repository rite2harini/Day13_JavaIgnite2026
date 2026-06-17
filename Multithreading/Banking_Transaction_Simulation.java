package JAVA_DAY_13;
import java.util.Random;

class BankAccount {
    private int balance = 10000;
    public synchronized void withdraw(int amount) {

        if (balance >= amount) {
            balance -= amount;
            System.out.println(
                Thread.currentThread().getName()+ " withdrew Rs." + amount+ " | Balance: Rs." + balance);
        } else {
            System.out.println(
                Thread.currentThread().getName()+ " tried to withdraw Rs." + amount+ " | Insufficient Balance");
        }
    }

    public synchronized void deposit(int amount) {

        balance += amount;
        System.out.println(
            Thread.currentThread().getName()+ " deposited Rs." + amount+ " | Balance: Rs." + balance);
    }
    public int getBalance() {
        return balance;
    }
}
class WithdrawThread extends Thread {

    BankAccount account;
    Random random = new Random();

    WithdrawThread(BankAccount account) {
        this.account = account;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {

            int amount = random.nextInt(1501) + 500; 

            account.withdraw(amount);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
class DepositThread extends Thread {

    BankAccount account;
    Random random = new Random();

    DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {
            int amount = random.nextInt(1501) + 500; 
            account.deposit(amount);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class BANKING_TRANSACTIONS_SIMULATIONS {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        BankAccount account = new BankAccount();

        WithdrawThread t1 = new WithdrawThread(account);
        DepositThread t2 = new DepositThread(account);

        t1.setName("Withdrawal Thread\n");
        t2.setName("Deposit Thread\n");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("\nFinal Balance: Rs." + account.getBalance());
    }
}
