package com.company;
import java.util.*;
class Backpack
{
    private ArrayList<Instructor> instructors;
    private ArrayList<Student> students;
    private ArrayList<ClassMaterial> material;
    private ArrayList<Comments> list_of_comments;
    public Backpack()
    {
        instructors= new ArrayList<Instructor>();
        students = new ArrayList<Student>();
        material = new ArrayList<ClassMaterial>();
        list_of_comments = new ArrayList<Comments>();
    }
    public void addInstructor()
    {
        Instructor obj1=new Instructor("I0",0,this);
        Instructor obj2=new Instructor("I1",1,this);
        instructors.add(obj1);
        instructors.add(obj2);
    }
    public void addStudent()
    {
        Student obj1=new Student("S0",0,this);
        Student obj2=new Student("S1",1,this);
        Student obj3=new Student("S2",2,this);
        students.add(obj1);
        students.add(obj2);
        students.add(obj3);
    }
    public void enterasInstructor()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Instructors:");
        for(Instructor x:instructors)
        {
            System.out.println(x.getId()+" - "+x.getName());
        }
        System.out.print("Choose id: ");
        int op=sc.nextInt();
        instructors.get(op).enter();
        return;
    }
    public void enterasStudent()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Students:");
        for(Student x:students)
        {
            System.out.println(x.getId()+" - "+x.getName());
        }
        System.out.print("Choose id: ");
        int op=sc.nextInt();
        students.get(op).enter();

    }
    ArrayList<ClassMaterial> getMaterial()
    {
        return material;
    }
    public void printMaterial()
    {
        for(ClassMaterial x:material)
        {
            x.view();
        }
    }
    public void addComments(Comments comment)
    {
        list_of_comments.add(comment);
    }
    public void printComments()
    {
        for(Comments x:list_of_comments)
        {
            x.view();
        }
    }
}

