/*static example*/
public class Tunastatic {
private String first;
private String last;
private static int member;//everytime an object is created memory is allocated fresh, hence the count is always stuck on 1, 
//but if we make it static it will get memory only once and will retain it
public Tunastatic(String fn, String ln) {
	first = fn;
	last = ln;
	member++;
	System.out.println(first+" "+last+" "+member);
}

public String getFirst()
{
	System.out.println("data is fetched, example of log capture");
	return first;
	
}

public String getLast()
{
	return last;
}

public static int getMembers()
{
	return member;
}

}
