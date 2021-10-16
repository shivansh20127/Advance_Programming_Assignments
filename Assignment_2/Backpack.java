import java.util.*;
class Backpack 
{
	private final Vector<Instructor> instructors;
    private final Vector<Student> students;
	Backpack()
	{
		instructors= new Vector<Instructor>();
		students = new Vector<Student>();
	}
	public void enterasInstructor()
	{
		System.out.println("Instructors:");
	}
	public void assigndt()
	{
		java.util.Date date=new java.util.Date();
		System.out.println("System Instantiated at");  
		System.out.println(date);
	}
}
