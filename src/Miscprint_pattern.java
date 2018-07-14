
public class Miscprint_pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int i,j,k;
for(i=1;i<=4;i++)
{
	
	
	for(j=i;j<=4;j++)
	{
		
		System.out.print(" "+j+" ");
				
	}
	for(k=1;k<i;k++)
	{
		System.out.print(" "+k +" ");
	}
	System.out.println("\n");
}
	
	}

}
//1  2  3  4 

//2  3  4  1 

//3  4  1  2 

//4  1  2  3 
