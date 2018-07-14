
public class Constructor_ex {
int num1;
int num2;
int result;
Constructor_ex (int num1,int num2){
	 this.num1=num1;//this refers to current instance, so if actual and instance variable names are same, we use this to differentiate
	 this.num2=num2;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Constructor_ex con1 = new Constructor_ex(4,5);
		System.out.println(con1.num1);
	}

}
