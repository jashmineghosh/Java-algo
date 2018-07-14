class Cal
{


	public int add(int...m)
	{
		int sum = 0;
		for(int i:m)
		{
			sum=sum+i;
		}
		return sum;
	}
}
public class Varargs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Cal c1 = new Cal();

System.out.println(c1.add(4,5,6,8,-2));
	}

}
   