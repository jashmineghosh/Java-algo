import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

public class Basic2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String name = "alip" + "bhuiya";
int i= 9;
System.out.println(name);
String name1 = "jas";
Integer name3 = name.compareTo(name1);
String name2 = name.concat(name1 );
System.out.println(name2);
System.out.println(name3);
Integer name4 = name.indexOf("a");
System.out.println(name4);
System.out.println(name.replace("a", "i"));
ArrayList first = new ArrayList();
first.add("abc");
first.add("def");
ListIterator it = first.listIterator();
while (it.hasNext()) //it.hasPrevious to print in reverse order
{
	System.out.println(it.next());
	System.out.println("hi");
}
	HashSet hset = new HashSet();
	hset.add("jkl"); // everything same but we use iterator, hashset is good for frequent insert and delete, while arraylist is good for search
	}

}
