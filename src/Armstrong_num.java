import java.util.Scanner;

public class Armstrong_num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int r;
		double sum = 0;
		double sqr;
		Scanner sc = new Scanner(System.in);
		 int i = sc.nextInt();
//		 int i =153;
		 int temp = i;
		 while( i>0)
		 {
			  r = i%10;
			  sqr=Math.pow(r, 3);
			  sum=sum+sqr;
			  i=i/10;
		 }
		 if(temp==sum)
		 {
			 System.out.println("armstrong num");
		 }
		 else
			 System.out.println("not armstrong num");
	}

}
