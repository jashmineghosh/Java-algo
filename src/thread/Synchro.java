package thread;

class counter {
	int count;
	synchronized public void increment()
	{
		 count = count +1;
	}
	
}
public class Synchro {

	public static void main(String[] args) throws InterruptedException {
		counter c = new counter();
//		c.increment();
//		c.increment();
		
		Thread t1 = new Thread(new Runnable()
		{
			public void run()
			{
			for (int i=0;i<=1000;i++)
			{
			c.increment();
		
			}
			}
			});
		
		Thread t2 = new Thread(new Runnable()
		{
			public void run()
			{
			for (int i=0;i<=1000;i++)
			{
			c.increment();
		
			}
			}
			});
//		synchronization problem here as both thread sometime it is fetching the value of count together, hence giving inconsistent results
			t1.start();
			t2.start();
			t1.join();
			t2.join();
		System.out.println("count " + c.count);
		
	}
}
