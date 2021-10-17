import java.util.*;
class Student extends user
{
	private final Scanner sc = Assignment2.sc;
	Student(String name,int id)
	{
		super(name, id);
	}
	public void enter() 
	{
		while(true)
		{
			System.out.println("Welcome "+this.getName());
			System.out.println("1. View lecture materials\n2. View assessments");
			System.out.println("3. Submit assessment\n4. View grades\n5. View comments");
			System.out.println("6. Add comments\n7. Logout");
			int op=sc.nextInt();
			if(op==1)
			{
				Backpack obj=new Backpack();
				obj.printMaterial();
			}
		}
	}
}
