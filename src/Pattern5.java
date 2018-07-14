
public class Pattern5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "JAVA";
		int i,j;
		
		for(i=1;i<=4;i++)
		{
			for(j=1;j<=4;j++)
			{
				if(j<i)
				{
					System.out.println(" ");
				}
				else
				System.out.println(s.charAt(j-1)+ "" );
			}
			System.out.println("");
		}
	}

}
