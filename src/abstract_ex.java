abstract class writer //final is just opposite, if class is final we cant create sub-class, if variable is final , its immutable, method is final then   no overridding
{
	abstract void writes();
}
class pen extends writer{

	@Override
	void writes() {
		// TODO Auto-generated method stub
	System.out.println("i am pen writing");	
	}
	
}
class pencil extends writer{

	@Override
	void writes() {
		// TODO Auto-generated method stub
		System.out.println("i am pencil writing");	
	}
	
}
public class abstract_ex {
	public static void main(String[] args) {
writer wr = new pencil();//we can create object of abstract class, hence we create object of sub class to call the method implementation
wr.writes();
	}
}
