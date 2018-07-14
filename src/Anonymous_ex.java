 class writer1 //final is just opposite, if class is final we cant create sub-class, if variable is final , its immutable, method is final then   no overridding
{
	public void writes() {
	System.out.println("anonymous example");
}
}
//class pen1 extends writer1{
//
//	
//	public void writes() {
//		// TODO Auto-generated method stub
//	System.out.println("i am pen writing");	
//	}
//	
//}
 //when the class will not be re-used, then such classes can be created as below
public class Anonymous_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
writer1 wr1 = new writer1()
{

	
	public void writes() {
		// TODO Auto-generated method stub
	System.out.println("i am pen writing");	
	}
	
};
wr1.writes();
	}

}
