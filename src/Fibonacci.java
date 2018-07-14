import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=0,a=1,b = 1;
		 Scanner sc = new Scanner(System.in);
		 System.out.println("enter number");
		 int n = sc.nextInt();
		
		
			System.out.println("1 1");
			
		while( k<=n)
		{
			k= a + b;
			System.out.println(k + "");
			a=b;
			b=k;
			
		}
	}

}
