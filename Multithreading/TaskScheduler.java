public class MultiThreadProgram {
	  public static void main(String[] args) {

	        Thread1 t1 = new Thread1();
	        Thread2 t2 = new Thread2();
	        Thread3 t3 = new Thread3();

	        t1.setName("Number Thread");
	        t2.setName("Even Thread");
	        t3.setName("Odd Thread");

	        t1.start();
	        t2.start();
	        t3.start();
	    }
	}
