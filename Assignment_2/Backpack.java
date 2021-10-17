import java.util.*;
class Backpack 
{
	private final ArrayList<Instructor> instructors;
    private final ArrayList<Student> students;
	private final Scanner sc = Assignment2.sc;
	Backpack()
	{
		instructors= new ArrayList<Instructor>();
		students = new ArrayList<Student>();
	}
	public void addInstructor(Instructor instructor)
	{
		instructors.add(instructor);
	}
	public void addStudent(Student student)
	{
		students.add(student);
	}
	public void enterasInstructor()
	{
		System.out.println("Instructors:");
		for(Instructor x:instructors)
		{
			System.out.println(x.getId()+" - "+x.getName());
		}
		int op=sc.nextInt();
		instructors.get(op-1).enter();
	}
	public void assigndt()
	{
		java.util.Date date=new java.util.Date();
		System.out.println("System Instantiated at");  
		System.out.println(date);
	}
}
