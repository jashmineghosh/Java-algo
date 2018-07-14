package thread;

class Hello implements Runnable
{
	public void run()
	{
		for (int i=0;i<=5;i++)
		{
		System.out.println("Hello");
	try { Thread.sleep(500);} catch(Exception e) {}
		}
		}
} 



//class Hi extends Thread
//{
//	public void run()
//	{
//		for (int i=0;i<=5;i++)
//		{
//		System.out.println("Hi");
//		try { Thread.sleep(500);} catch(Exception e) {}
//		}
//		}
//}
public class ThreadDemo {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
				
//		Hello obj1 = new Hello();
		Runnable obj1 = new Hello();
		Thread t1 = new Thread(() ->
		{
			for (int i=0;i<=5;i++)
			{
			System.out.println("Hi");
		try { Thread.sleep(500);} catch(Exception e) {}
			}
			}
		);
		Thread t2 = new Thread(obj1); // since we need to call run method hence we are passing the runnable obj to thread, so it call run method of our class
		
//		obj.start(); this is used when we use Thread class, another way is implementing Runnable interface
		t1.start();
		try { Thread.sleep(10);} catch(Exception e) {}
		t2.start();
		
		
	}

}
