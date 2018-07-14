package thread;


public class ThreadDemo1 {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
				
		Hello obj1 = new Hello();
		
		Thread t1 = new Thread(() ->
		{
			for (int i=0;i<=5;i++)
			{
			System.out.println("Hi" + Thread.currentThread().getPriority()); // default priority of thread is 5, we can use constant like MIN_PRIORITY/MAX_/NORM_
		try { Thread.sleep(500);} catch(Exception e) {}
			}
			}
		);
		Thread t2 = new Thread(()->
		{
				for (int i=0;i<=5;i++)
		{
		System.out.println("Hello");
	try { Thread.sleep(500);} catch(Exception e) {}
		}},"Hello thread");
		
//		obj.start(); this is used when we use Thread class, another way is implementing Runnable interface
		t1.start();
		try { Thread.sleep(10);} catch(Exception e) {}
		t2.start();
		
		t1.setName("HI thread"); // we are setting name for thread , used when there are lot of threads to manage
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		System.out.println(t1.isAlive());
		t1.join();
		t2.join();
		System.out.println("bye"); // here main class method needs to be executed last hence we are joining the thread then executing main class method
		System.out.println(t1.isAlive()); // returns boolean false as after joining thread it dies.
	}

}
