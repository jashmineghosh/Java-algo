

public class min_max_arr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//System.out.println("new to java");
//int a = 2;
//int b = 3;
//int Sum = a+b;
//System.out.println("Sum is = " +Sum);
		
		int abc[][]= {{2,5,40},{0,9,2},{7,8,1}};

		int max= abc[0][0];  
		int maxcol = 0 ;
		
		for(int i=0;i<3;i++)
		{ 

		for(int j=0;j<3;j++)
		{

		if (abc[i][j]>max)
		{ 

		max=abc[i][j];
		maxcol=j;
		}
		
		}
	}
		int k = 0;
		int min=abc[k][maxcol];
		
		for(k=0;k<3;k++)
		{
			if(abc[k][maxcol]<min)
			{
				min=abc[k][maxcol];
			}
		}
		System.out.println(min);//find the min value in the col where max value of aray is present
		System.out.println("max is " +max);//find the max val in multi dim array
		
	}
	
}
