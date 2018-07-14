interface Demo{
	int i=9;
	static void sample()
	{
		System.out.println("static is allowed");
	}
	void show();
	default void printing()
	{
		// TODO Auto-generated method stub
		System.out.println("i m demo printing");
	};
}
interface Demo1{
	void show();
	default void printing() {
	System.out.println("i m demo1 printing");
}
}
class abc implements Demo1,Demo{ //here if i delete printing implementation , throws ambiguity problem
	//1 way is to define the method in this class, else use super keyword

	
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("i m show");
//		i=10; any variable declared in interface becomes final
	}
	
//	public void printing() {
//		// TODO Auto-generated method stub
//		System.out.println("i m new priting");
//	}
	public void printing()
	{
	Demo.super.printing();
}
}

public class InterfaceDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
abc obj = new abc();
obj.show();
obj.printing();
Demo.sample();//static method, no object required

	}

}
