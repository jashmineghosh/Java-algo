import java.util.Scanner;

public class Odd_Even {

	Scanner sc = new Scanner(System.in);
	 int int1 = sc.nextInt();
	 
	 public void eval()
	 {
		
		 if(int1%2==0)
		 {
			System.out.println("number is even" +int1); 
		 }
		 else
		 {
				System.out.println("number is odd" +int1); 

		 }
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Odd_Even p1 = new Odd_Even();
		p1.eval();
		
	}

}
