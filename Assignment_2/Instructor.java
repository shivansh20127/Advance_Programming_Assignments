package com.company;

import java.util.Scanner;
class Instructor extends Data implements user
{
    private final Backpack obj;
    Instructor(String name,int id,Backpack obj)
    {
        super(name,id);
        this.obj=obj;
    }
    public void addclassmaterial()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("1. Add Lecture Slide\n2. Add Lecture Video");
        int x=sc.nextInt();
        if(x==1)
        {
            ClassMaterial lectureSlide = new Slides(this);
            obj.getMaterial().add(lectureSlide);
        }
        if(x==2)
        {
            ClassMaterial lectureVideo = new Lecture(this);
            obj.getMaterial().add(lectureVideo);
        }
    }
    @Override
    public void viewLecture()
    {
        obj.printMaterial();
    }
    @Override
    public void viewAssessment() {
    }
    @Override
    public void addComment()
    {
        Comments new_comm=new Comments(this);
        obj.addComments(new_comm);
    }
    @Override
    public void viewComment()
    {
        obj.printComments();
    }
    public void enter()
    {
        Scanner sc=new Scanner(System.in);
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
                addclassmaterial();
            }
            if(op==3)
            {
                viewLecture();
            }
            if(op==7)
            {
                viewComment();
            }
            if(op==8)
            {
                addComment();
            }
            if(op==9) { return; }
        }
    }
}

