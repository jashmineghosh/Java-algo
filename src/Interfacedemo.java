//interface type-> normal (many methods), single abstract method also called functional interface(1 method), marker (no method)
@FunctionalInterface //only 1 method is allowed with this annotation, there is an exception thou
//if another method is default in an interface, we can also define it and it goes with above annotation, also it be over-ridden in the class implementing it
interface AB{
	void show();
//	void printing();
}

//class abc implements AB{
//
//	@Override
//	public void show() {
//		// TODO Auto-generated method stub
//		System.out.println("lambda example");
//	}
//	
//}
public class Interfacedemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 AB lm = () ->System.out.println("lambda example"); // we have provided full implementation in single line
		 
lm.show();
	}

}
