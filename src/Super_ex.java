class A{
	int i;
	A()
	
	{
	System.out.println("in A");
}
	public void show()
	{
	System.out.println("i m ahow in A");	
	}
	A(int i)
	{
	System.out.println("in A int");
}
}
class B extends A{
	int i;
	public void conf()
	{
		System.out.println("hi");
	}
	B()
	{
		super(5);
		super.i=8;//assigning the variable value of i in super class;
	System.out.println("in B");
}
	@Override // we us this annotation so while overriding if we do some mistake like write show1, it will be captured @ compile time
	public void show()
	{
		super.show();
	System.out.println("i m show in B");	
	}
	B(int i)
	{
		super(i);
	System.out.println("in B int");
}	
}
class C extends A
{
	
	public void show()
	{
		
	System.out.println("i m show in C");	
	}
}

public class Super_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
A obj1= new B();
//obj1.show();
//obj1.conf(); // this code is giving error as the reference is made of parent class, and there is no method conf there
	obj1= new C(); // this is runtime polymorphism
	obj1.show();  // this is dynamic method dispatch, achieved by method overridding
	}

}
