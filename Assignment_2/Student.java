package com.company;

import java.util.*;
class Student extends Data implements user
{
    private final Backpack obj;
    Student(String _name,int _id,Backpack obj)
    {
        super(_name,_id);
        this.obj=obj;
    }
    @Override
    public void viewLecture()
    {
        obj.printMaterial();
    }
    @Override
    public void viewAssessment()
    {
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
            System.out.println("1. View lecture materials\n2. View assessments");
            System.out.println("3. Submit assessment\n4. View grades\n5. View comments");
            System.out.println("6. Add comments\n7. Logout");
            int op=sc.nextInt();
            if(op==1)
            {
                viewLecture();
            }
            if(op==5)
            {
                viewComment();
            }
            if(op==6)
            {
                addComment();
            }
            if(op==7){ return; }
        }
    }
}

