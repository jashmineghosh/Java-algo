import java.util.Scanner;

public class Floyds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner user_input = new Scanner(System.in);
int i,j,k=1,num;
System.out.println("enter number of rows:" +user_input);
num=user_input.nextInt();
for(i=1;i<=num;i++)
{
	for(j=1;j<=i;j++,k++)
	{
		System.out.print(k+" ");
	}
	System.out.println("\n");
}
	}

}
