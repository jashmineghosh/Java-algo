

class outer{
int i ;
public void show()
{
	
}
class inner
{
	public void display()
	{
		System.out.println("in inner");
	}
}
}
public class InnerOuter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
outer obj = new outer();
 obj.show();
 outer.inner obj1 = obj.new inner(); // if inner class is static, the we use this syntax to get same result  outer.inner obj1 = new outer.inner();
obj1.display();
	}

}
