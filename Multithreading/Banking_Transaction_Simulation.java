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
