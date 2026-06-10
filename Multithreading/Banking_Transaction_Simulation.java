import java.util.Random;

class BankAccount {
    private int balance = 10000;

    // Deposit Method
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(
                Thread.currentThread().getName()
                        + " Deposited: " + amount
                        + " | Balance: " + balance);
    }

    // Withdraw Method
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(
                    Thread.currentThread().getName()
                            + " Withdrawn: " + amount
                            + " | Balance: " + balance);
        } else {
            System.out.println(
                    Thread.currentThread().getName()
                            + " Withdrawal of " + amount
                            + " Failed (Insufficient Balance)"
                            + " | Balance: " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}

// Withdrawal Thread
class WithdrawThread extends Thread {
    BankAccount account;
    Random random = new Random();

    WithdrawThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            int amount = random.nextInt(1501) + 500; // 500–2000
            account.withdraw(amount);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}

// Deposit Thread
class DepositThread extends Thread {
    BankAccount account;
    Random random = new Random();

    DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            int amount = random.nextInt(1501) + 500; // 500–2000
            account.deposit(amount);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}


public class BankSystem {
	public static void main(String[] args) {

        BankAccount account = new BankAccount();

        WithdrawThread t1 = new WithdrawThread(account);
        DepositThread t2 = new DepositThread(account);

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
        }

        System.out.println("\nFinal Balance: " + account.getBalance());
    }

}
