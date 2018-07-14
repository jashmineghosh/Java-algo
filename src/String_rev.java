import java.util.Scanner;

public class String_rev {

	
	static Scanner sc = new Scanner(System.in);
	static String s = sc.nextLine();
	static String rev= "";
	  
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int len = s.length();
		for(int i=len-1; i>=0;i--)
		{
			rev = rev + s.charAt(i);
			
		}
		System.out.println("reverse string "+ rev);
		if(s.equalsIgnoreCase(rev))
		{
			System.out.println("polyndrome " +rev +" " + s);
			
		}
		else
		{
			System.out.println(" not polyndrome " +rev +" " + s);
		}
		//alternate option to use java api
		StringBuffer bf = new StringBuffer(s);
		String rev1 = bf.reverse().toString();
		System.out.println("reverse string "+ rev1);
		StringBuffer rev2 = bf.append("abc");
		System.out.println("append string"+ rev2);
	}

}
