import java.util.Random;

class BankAccount {
    private int balance = 10000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName()
                + " Deposited: " + amount
                + " | Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName()
                    + " Withdrawn: " + amount
                    + " | Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " Cannot withdraw " + amount
                    + " | Insufficient Balance: " + balance);
        }
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
        }
    }
}

public class BankingTransactionSimulation {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        WithdrawThread t1 = new WithdrawThread(account);
        DepositThread t2 = new DepositThread(account);

        t1.setName("WithdrawThread");
        t2.setName("DepositThread");

        t1.start();
        t2.start();
    }
}
