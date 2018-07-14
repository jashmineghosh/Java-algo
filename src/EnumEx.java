enum Mobile{
	APPLE,SAMSUNG(30),HTC;
	
	int price;
	public int getPrice() {
		return price;
	}
	Mobile()
	{
	price = 20;	
	}
	Mobile(int p)
	{
		price = p;
	}
}
public class EnumEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Mobile.APPLE);
		Mobile m = Mobile.APPLE;
//		Mobile.APPLE.price = 20;
		switch(m)
		{
			case APPLE: System.out.println("apple is good");
			break;
			case SAMSUNG: System.out.println("samsung is good");
			break;
//			case JAS: System.out.println("jas is good"); this will give error as it will work only for constants defined in enum.
		}
		Mobile m1 [] = Mobile.values();
		for(Mobile mob : m1)
		{
			System.out.println(mob);
		}
		System.out.println(Mobile.APPLE.getPrice());
		System.out.println(Mobile.SAMSUNG.getPrice());
		System.out.println(m.ordinal());
		System.out.println(Mobile.SAMSUNG.ordinal());
	}

}
