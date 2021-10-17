import java.util.*;
class Backpack 
{
	private ArrayList<Instructor> instructors;
    private ArrayList<Student> students;
	private ArrayList<ClassMaterial> material;
	private final Scanner sc = Assignment2.sc;
	Backpack()
	{
		instructors= new ArrayList<Instructor>();
		students = new ArrayList<Student>();
		material = new ArrayList<ClassMaterial>();
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
		return;
	}
	public void enterasStudent()
	{
		System.out.println("Students:");
		for(Student x:students)
		{
			System.out.println(x.getId()+" - "+x.getName());
		}
		int op=sc.nextInt();
		students.get(op-1).enter();
	}
	public void addMaterial(String _name)
	{
		System.out.println("1. Add Lecture Slide\n2. Add Lecture Video");
		int x=sc.nextInt();
		if(x==1)
		{
			ClassMaterial lectureSlide = new Slides(_name);
			material.add(lectureSlide);
		}
	}
	public void printMaterial()
	{
		for(ClassMaterial x:material)
		{
			x.view();
		}
	}
}
