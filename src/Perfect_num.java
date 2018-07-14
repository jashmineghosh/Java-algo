import java.util.Scanner;

public class Perfect_num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int r;
		double sum = 0;
		
		Scanner sc = new Scanner(System.in);
		 int i = sc.nextInt();
		 int temp=i;
//		 int i =15;
		 int j = i/2;
		 for(int k=1;k<=j;k++)
		 {
			 if(i%k==0)
			 {
			 sum=sum+k;
			 }
		 }
		 if(temp==sum)
		 {
			 System.out.println("perfect num");
		 }
		 else
			 System.out.println("not perfect num");
	}

}
