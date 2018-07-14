
public class JaggedArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int d[][] = {
		{2,3,4,5},
		{1,7,8},
		{90,2}
	};
//for(int i=0;i<d.length;i++)
//{
//	for(int j = 0;j<d[i].length;j++)
//	{
//		System.out.println(" "+d[i][j]);
//	}
//	System.out.println("\n");
//}
for(int k[]: d)
{
	
	for(int l:k)
	{
		System.out.println(" " +l);
	}
	System.out.println();
}
	}
	}


