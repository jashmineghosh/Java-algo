
public class Pattern9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i,j,k;
		for(i=1;i<=4;i++)
		{
			
			
			for(j=1;j<=i;j++)
			{
				
				System.out.print(" "+j+" ");
						
			}
			for(k=i-1;k>=0;k--)
			{
				if(k==0)
					System.out.print("");
				else
				System.out.print(" "+k +" ");
			}
			System.out.println("\n");
		}
			
			}

	}


