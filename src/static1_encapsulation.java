
public class static1_encapsulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tunastatic member= new Tunastatic("meg","fox");
		Tunastatic member2= new Tunastatic("tay","swift");
		
		// its always a safe practice to bind data with methods, so we can maintain a log and check on who is updating or accessing data
	System.out.println(member2.getFirst());
	System.out.println(member2.getLast());
	System.out.println(member2.getMembers()); // we change the object but it is returning same value as its static
	System.out.println(Tunastatic.getMembers()); //static methods can be called by class name directly as it does not change from obj to obj
	
	}

}
