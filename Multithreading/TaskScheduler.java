package JavaIgniteDay13;
class Thread1 extends Thread
{
	public void run()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}
}

class Thread2 extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			if(i%2==0) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
			}
		}
	}
}

class Thread3 extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			if(i%2!=0) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
			}
		}
	}
}

public class Task_Scheduler {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		Thread3 thread3 = new Thread3();
		
		thread1.setName("Thread 1");
		thread2.setName("Thread 2");
		thread3.setName("Thread 3");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}
