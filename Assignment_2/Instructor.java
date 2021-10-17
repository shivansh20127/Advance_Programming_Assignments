import java.util.Scanner;
class Instructor extends user
{
	private final Scanner sc = Assignment2.sc;
	Instructor(String name,int id)
	{
		super(name, id);
	}
	public void enter() 
	{
		while(true)
		{
			System.out.println("Welcome "+this.getName());
			System.out.println("1. Add class material\n2. Add assessments");
			System.out.println("3. View lecture materials\n4. View assessments");
			System.out.println("5. Grade assessments\n6. Close assessment");
			System.out.println("7. View comments\n8. Add comments\n9. Logout");
			int op=sc.nextInt();
			if(op==1)
			{
				Backpack obj=new Backpack();
				obj.addMaterial(this.getName());
			}
			if(op==3)
			{
				Backpack obj=new Backpack();
				obj.printMaterial();
			}
			if(op==9) { return; }
		}
	}
}
