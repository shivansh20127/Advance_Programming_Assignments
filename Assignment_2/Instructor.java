import java.util.Scanner;
class Instructor extends user
{
	protected final Scanner sc = new Scanner(System.in);
	Instructor(String name,int id)
	{
		super(name, id);
	}
	public void enter() 
	{
		while(true)
		{
			System.out.println("Welcome "+this.getName());
			
		}
	}
}
