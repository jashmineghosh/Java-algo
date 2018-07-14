import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		 int i = sc.nextInt();
		 int temp =i;
//		 int i =15;
		 int j = i/2;
		 boolean isPrime= true;
		 for(int k=2;k<j;k++)
		 {
			 if(i%k==0)
			 {
				 isPrime= false;
				 break;
			 }
			  			 
		 }

		 if(isPrime)
		 {
			 System.out.println(i + "is a prime");
		 }
		 else
			 System.out.println(i + "is not a prime"); 
		 }

	

}
